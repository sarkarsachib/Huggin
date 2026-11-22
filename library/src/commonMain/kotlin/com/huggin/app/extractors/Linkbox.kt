package com.huggin.app.extractors

import com.fasterxml.jackson.annotation.JsonProperty
import com.huggin.app.SubtitleFile
import com.huggin.app.app
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.getQualityFromName
import com.huggin.app.utils.newExtractorLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class Linkbox : ExtractorApi() {
    override val name = "Linkbox"
    override val mainUrl = "https://www.linkbox.to"
    override val requiresReferer = true

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ) {
        val token = Regex("""(?:/f/|/file/|\?id=)(\w+)""").find(url)?.groupValues?.get(1)
        val id = app.get("$mainUrl/api/file/share_out_list/?sortField=utime&sortAsc=0&pageNo=1&pageSize=50&shareToken=$token").parsedSafe<Responses>()?.data?.itemId
        app.get("$mainUrl/api/file/detail?itemId=$id", referer = url)
            .parsedSafe<Responses>()?.data?.itemInfo?.resolutionList?.map { link ->
                callback.invoke(
                    newExtractorLink(
                        name,
                        name,
                        link.url ?: return@map null,
                    ) {
                        this.referer = url
                        this.quality = getQualityFromName(link.resolution)
                    }
                )
            }
    }

    @Serializable
    data class Resolutions(
        @JsonProperty("url") @SerialName("url") val url: String? = null,
        @JsonProperty("resolution") @SerialName("resolution") val resolution: String? = null,
    )

    @Serializable
    data class ItemInfo(
        @JsonProperty("resolutionList") @SerialName("resolutionList") val resolutionList: ArrayList<Resolutions>? = arrayListOf(),
    )

    @Serializable
    data class Data(
        @JsonProperty("itemInfo") @SerialName("itemInfo") val itemInfo: ItemInfo? = null,
        @JsonProperty("itemId") @SerialName("itemId") val itemId: String? = null,
    )

    @Serializable
    data class Responses(
        @JsonProperty("data") @SerialName("data") val data: Data? = null,
    )
}
