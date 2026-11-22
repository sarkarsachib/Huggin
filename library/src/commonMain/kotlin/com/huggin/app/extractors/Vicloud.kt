package com.huggin.app.extractors

import com.fasterxml.jackson.annotation.JsonProperty
import com.huggin.app.APIHolder.unixTimeMS
import com.huggin.app.SubtitleFile
import com.huggin.app.app
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.getQualityFromName
import com.huggin.app.utils.newExtractorLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class Vicloud : ExtractorApi() {
    override val name = "Vicloud"
    override val mainUrl = "https://vicloud.sbs"
    override val requiresReferer = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ) {
        val id = Regex("\"apiQuery\":\"(.*?)\"").find(app.get(url).text)?.groupValues?.getOrNull(1)
        app.get(
            "$mainUrl/api/?$id=&_=$unixTimeMS",
            headers = mapOf("X-Requested-With" to "XMLHttpRequest"),
            referer = url,
        ).parsedSafe<Responses>()?.sources?.map { source ->
            callback.invoke(
                newExtractorLink(
                    name,
                    name,
                    source.file ?: return@map null,
                ) {
                    this.referer = url
                    this.quality = getQualityFromName(source.label)
                }
            )
        }
    }

    @Serializable
    private data class Sources(
        @JsonProperty("file") @SerialName("file") val file: String? = null,
        @JsonProperty("label") @SerialName("label") val label: String? = null,
    )

    @Serializable
    private data class Responses(
        @JsonProperty("sources") @SerialName("sources") val sources: List<Sources>? = arrayListOf(),
    )
}
