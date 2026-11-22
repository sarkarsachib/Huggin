package com.huggin.app.extractors

import com.huggin.app.SubtitleFile
import com.huggin.app.app
import com.huggin.app.extractors.helper.JwPlayerHelper
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.getAndUnpack
import com.huggin.app.utils.getPacked

open class StreamoUpload : ExtractorApi() {
    override val name = "StreamoUpload"
    override val mainUrl = "https://streamoupload.xyz"
    override val requiresReferer = true

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val response = app.get(url, referer = referer)
        response.document.select("script").map { script ->
            if (getPacked(script.data()) != null) {
                val data = getAndUnpack(script.data())
                JwPlayerHelper.extractStreamLinks(data, name, mainUrl, callback, subtitleCallback)
            }
        }
    }
}
