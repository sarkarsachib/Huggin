package com.huggin.app.extractors

import com.huggin.app.SubtitleFile
import com.huggin.app.utils.ExtractorApi
import com.huggin.app.utils.ExtractorLink

expect open class YoutubeExtractor() : ExtractorApi {
    override val mainUrl: String
    override val name: String
    override val requiresReferer: Boolean
    override suspend fun getUrl(
        url: String,
        referer: String?,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    )
}

class YoutubeShortLinkExtractor : YoutubeExtractor() {
    override val mainUrl = "https://youtu.be"
}

class YoutubeMobileExtractor : YoutubeExtractor() {
    override val mainUrl = "https://m.youtube.com"
}

class YoutubeNoCookieExtractor : YoutubeExtractor() {
    override val mainUrl = "https://www.youtube-nocookie.com"
}
