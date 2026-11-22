package com.huggin.app.extractors

import com.huggin.app.SubtitleFile
import com.huggin.app.app
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.INFER_TYPE
import com.huggin.app.utils.Qualities
import com.huggin.app.utils.newExtractorLink

open class Wibufile : ExtractorApi() {
    override val name: String = "Wibufile"
    override val mainUrl: String = "https://wibufile.com"
    override val requiresReferer = false

    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        val res = app.get(url).text
        val video = Regex("src: ['\"](.*?)['\"]").find(res)?.groupValues?.get(1)

        callback.invoke(
            newExtractorLink(
                name,
                name,
                video ?: return,
            ) {
                this.referer = "$mainUrl/"
                this.quality = Qualities.Unknown.value
            }
        )
    }
}