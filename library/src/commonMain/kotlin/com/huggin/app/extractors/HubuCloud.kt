package com.huggin.app.extractors

import com.huggin.app.SubtitleFile
import com.huggin.app.app
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.newExtractorLink

open class HubuCloud: ExtractorApi() {
    override val name: String = "Hubu"
    override val mainUrl: String = "https://hubu.cloud"
    override val requiresReferer: Boolean = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val doc = app.get(url).document

        val streamUrl = doc.select("source").attr("src")
        callback.invoke(newExtractorLink(source = name, name = name, url = streamUrl))
    }
}