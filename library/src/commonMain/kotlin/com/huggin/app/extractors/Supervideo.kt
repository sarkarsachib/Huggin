package com.huggin.app.extractors

import com.huggin.app.SubtitleFile
import com.huggin.app.app
import com.huggin.app.extractors.helper.JwPlayerHelper
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.JsUnpacker

open class Supervideo : ExtractorApi() {
    override var name = "Supervideo"
    override var mainUrl = "https://supervideo.cc"
    override val requiresReferer = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val response = app.get(url).text
        val jstounpack = Regex("eval((.|\\n)*?)</script>").find(response)?.groups?.get(1)?.value
        val unpacked = JsUnpacker(jstounpack).unpack()

        JwPlayerHelper.extractStreamLinks(unpacked.orEmpty(), name, mainUrl, callback, subtitleCallback)
    }
}