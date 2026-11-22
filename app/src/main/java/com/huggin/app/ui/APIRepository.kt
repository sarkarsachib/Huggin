package com.huggin.app.ui

import com.huggin.app.APIHolder.unixTime
import com.huggin.app.APIHolder.unixTimeMS
import com.huggin.app.DubStatus
import com.huggin.app.ErrorLoadingException
import com.huggin.app.HomePageResponse
import com.huggin.app.LoadResponse
import com.huggin.app.MainAPI
import com.huggin.app.MainActivity.Companion.afterPluginsLoadedEvent
import com.huggin.app.MainPageRequest
import com.huggin.app.SearchResponseList
import com.huggin.app.SubtitleFile
import com.huggin.app.TvType
import com.huggin.app.fixUrl
import com.huggin.app.mvvm.Resource
import com.huggin.app.mvvm.logError
import com.huggin.app.mvvm.safeApiCall
import com.huggin.app.newSearchResponseList
import com.huggin.app.utils.Coroutines.atomicListOf
import com.huggin.app.utils.ExtractorLink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout

class APIRepository(val api: MainAPI) {
    companion object {
        // 2 minute timeout to prevent bad extensions/extractors from hogging the resources
        // No real provider should take longer, so we hard kill them.
        private const val DEFAULT_TIMEOUT = 120_000L
        private const val MAX_TIMEOUT = 4 * DEFAULT_TIMEOUT
        private const val MIN_TIMEOUT = 5_000L

        var dubStatusActive = HashSet<DubStatus>()

        val noneApi = object : MainAPI() {
            override var name = "None"
            override val supportedTypes = emptySet<TvType>()
            override var lang = ""
        }
        val randomApi = object : MainAPI() {
            override var name = "Random"
            override val supportedTypes = emptySet<TvType>()
            override var lang = ""
        }

        fun isInvalidData(data: String): Boolean {
            return data.isEmpty() || data == "[]" || data == "about:blank"
        }

        data class SavedLoadResponse(
            val unixTime: Long,
            val response: LoadResponse,
            val hash: Pair<String, String>
        )

        private val cache = atomicListOf<SavedLoadResponse>()

        init {
            afterPluginsLoadedEvent += { forceReload ->
                if (forceReload) cache.clear()
            }
        }

        private var cacheIndex: Int = 0
        const val CACHE_SIZE = 20

        fun getTimeout(desired: Long?): Long {
            return (desired ?: DEFAULT_TIMEOUT).coerceIn(MIN_TIMEOUT, MAX_TIMEOUT)
        }
    }

    val hasMainPage = api.hasMainPage
    val providerType = api.providerType
    val name = api.name
    val mainUrl = api.mainUrl
    val mainPage = api.mainPage
    val hasQuickSearch = api.hasQuickSearch
    val vpnStatus = api.vpnStatus

    suspend fun load(url: String): Resource<LoadResponse> {
        return safeApiCall {
            withTimeout(getTimeout(api.loadTimeoutMs)) {
                if (isInvalidData(url)) throw ErrorLoadingException()
                val fixedUrl = api.fixUrl(url)
                val lookingForHash = Pair(api.name, fixedUrl)

                val cached = cache.withLock {
                    var found: LoadResponse? = null
                    for (item in cache) {
                        // 10 min save
                        if (item.hash == lookingForHash && (unixTime - item.unixTime) < 60 * 10) {
                            found = item.response
                            break
                        }
                    }
                    found
                }

                if (cached != null) return@withTimeout cached
                api.load(fixedUrl)?.also { response ->
                    // Remove all blank tags as early as possible
                    response.tags = response.tags?.filter { it.isNotBlank() }
                    val add = SavedLoadResponse(unixTime, response, lookingForHash)

                    cache.withLock {
                        if (cache.size > CACHE_SIZE) {
                            cache[cacheIndex] = add // rolling cache
                            cacheIndex = (cacheIndex + 1) % CACHE_SIZE
                        } else {
                            cache.add(add)
                        }
                    }
                } ?: throw ErrorLoadingException()
            }
        }
    }

    suspend fun search(query: String, page: Int): Resource<SearchResponseList> {
        if (query.isEmpty())
            return Resource.Success(newSearchResponseList(emptyList()))

        return safeApiCall {
            withTimeout(getTimeout(api.searchTimeoutMs)) {
                (api.search(query, page)
                    ?: throw ErrorLoadingException())
                //                .filter { typesActive.contains(it.type) }
            }
        }
    }

    suspend fun quickSearch(query: String): Resource<SearchResponseList> {
        if (query.isEmpty())
            return Resource.Success(newSearchResponseList(emptyList()))

        return safeApiCall {
            withTimeout(getTimeout(api.quickSearchTimeoutMs)) {
                newSearchResponseList(
                    api.quickSearch(query) ?: throw ErrorLoadingException(),
                    false
                )
            }
        }
    }

    suspend fun waitForHomeDelay() {
        val delta = api.sequentialMainPageScrollDelay + api.lastHomepageRequest - unixTimeMS
        if (delta < 0) return
        delay(delta)
    }

    suspend fun getMainPage(page: Int, nameIndex: Int? = null): Resource<List<HomePageResponse?>> {
        return safeApiCall {
            withTimeout(getTimeout(api.getMainPageTimeoutMs)) {
                api.lastHomepageRequest = unixTimeMS

                nameIndex?.let { api.mainPage.getOrNull(it) }?.let { data ->
                    listOf(
                        api.getMainPage(
                            page,
                            MainPageRequest(data.name, data.data, data.horizontalImages)
                        )
                    )
                } ?: run {
                    if (api.sequentialMainPage) {
                        var first = true
                        api.mainPage.map { data ->
                            if (!first) // dont want to sleep on first request
                                delay(api.sequentialMainPageDelay)
                            first = false

                            api.getMainPage(
                                page,
                                MainPageRequest(data.name, data.data, data.horizontalImages)
                            )
                        }
                    } else {
                        with(CoroutineScope(coroutineContext)) {
                            api.mainPage.map { data ->
                                async {
                                    api.getMainPage(
                                        page,
                                        MainPageRequest(data.name, data.data, data.horizontalImages)
                                    )
                                }
                            }.map { it.await() }
                        }
                    }
                }
            }
        }
    }

    suspend fun extractorVerifierJob(extractorData: String?) {
        safeApiCall {
            api.extractorVerifierJob(extractorData)
        }
    }

    suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ): Boolean {
        if (isInvalidData(data)) return false // this makes providers cleaner
        return try {
            withTimeout(getTimeout(api.loadLinksTimeoutMs)) {
                api.loadLinks(data, isCasting, subtitleCallback, callback)
            }
        } catch (throwable: Throwable) {
            logError(throwable)
            return false
        }
    }
}
