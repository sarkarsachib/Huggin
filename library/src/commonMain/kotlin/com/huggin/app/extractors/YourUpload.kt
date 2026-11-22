package com.huggin.app.extractors

import com.fasterxml.jackson.annotation.JsonProperty
import com.huggin.app.app
import com.huggin.app.utils.AppUtils.tryParseJson
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.getQualityFromName
import com.huggin.app.utils.newExtractorLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

open class YourUpload : ExtractorApi() {
    override val name = "Yourupload"
    override val mainUrl = "https://www.yourupload.com"
    override val requiresReferer = false

    override suspend fun getUrl(url: String, referer: String?): List<ExtractorLink> {
        val sources = mutableListOf<ExtractorLink>()
        with(app.get(url).document) {
            val quality = Regex("\\d{3,4}p").find(this.select("title").text())?.groupValues?.get(0)
            this.select("script").map { script ->
                if (script.data().contains("var jwplayerOptions = {")) {
                    val data = script.data().substringAfter("var jwplayerOptions = {").substringBefore(",\n")
                    val link = tryParseJson<ResponseSource>(
                        "{${data.replace("file", "\"file\"").replace("'", "\"")}}"
                    )

                    sources.add(
                        newExtractorLink(
                            source = name,
                            name = name,
                            url = link!!.file,
                        ) {
                            this.referer = url
                            this.quality = getQualityFromName(quality)
                        }
                    )
                }
            }
        }

        return sources
    }

    @Serializable
    private data class ResponseSource(
        @JsonProperty("file") @SerialName("file") val file: String,
    )
}
