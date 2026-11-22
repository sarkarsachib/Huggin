package com.huggin.app.extractors

import com.huggin.app.SubtitleFile
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.ExtractorLinkType
import com.huggin.app.utils.newExtractorLink

open class Streamcash: ExtractorApi() {
    override val name: String = "Streamcash"
    override val mainUrl: String = "https://streamcash.to"
    open val cdnUrl: String = "https://cdn.streamcash.to"
    override val requiresReferer: Boolean = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val id = url.removeSuffix("/").substringAfterLast("/")
        callback.invoke(
            newExtractorLink(
                name = name,
                source = name,
                url = "$cdnUrl/videos/$id/index.m3u8",
                type = ExtractorLinkType.M3U8
            )
        )
    }
}