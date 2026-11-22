package com.huggin.app.utils

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fleeksoft.ksoup.Ksoup
import com.huggin.app.AudioFile
import com.huggin.app.IDownloadableMinimum
import com.huggin.app.SubtitleFile
import com.huggin.app.USER_AGENT
import com.huggin.app.app
import com.huggin.app.extractors.Acefile
import com.huggin.app.extractors.Ahvsh
import com.huggin.app.extractors.Aico
import com.huggin.app.extractors.Antarcticadocs
import com.huggin.app.extractors.Asnwish
import com.huggin.app.extractors.Auvexiug
import com.huggin.app.extractors.Awish
import com.huggin.app.extractors.BgwpCC
import com.huggin.app.extractors.BigwarpArt
import com.huggin.app.extractors.BigwarpIO
import com.huggin.app.extractors.Blogger
import com.huggin.app.extractors.ByseSX
import com.huggin.app.extractors.Bysezejataos
import com.huggin.app.extractors.ByseBuho
import com.huggin.app.extractors.ByseVepoin
import com.huggin.app.extractors.ByseQekaho
import com.huggin.app.extractors.Cavanhabg
import com.huggin.app.extractors.Cda
import com.huggin.app.extractors.Cdnplayer
import com.huggin.app.extractors.CdnwishCom
import com.huggin.app.extractors.CloudMailRu
import com.huggin.app.extractors.ContentX
import com.huggin.app.extractors.CsstOnline
import com.huggin.app.extractors.D0000d
import com.huggin.app.extractors.D000dCom
import com.huggin.app.extractors.DBfilm
import com.huggin.app.extractors.Dailymotion
import com.huggin.app.extractors.DatabaseGdrive
import com.huggin.app.extractors.DatabaseGdrive2
import com.huggin.app.extractors.DesuArcg
import com.huggin.app.extractors.DesuDrive
import com.huggin.app.extractors.DesuOdchan
import com.huggin.app.extractors.DesuOdvip
import com.huggin.app.extractors.Dhcplay
import com.huggin.app.extractors.Dhtpre
import com.huggin.app.extractors.Dokicloud
import com.huggin.app.extractors.DoodCxExtractor
import com.huggin.app.extractors.DoodLaExtractor
import com.huggin.app.extractors.DoodPmExtractor
import com.huggin.app.extractors.DoodShExtractor
import com.huggin.app.extractors.DoodSoExtractor
import com.huggin.app.extractors.DoodToExtractor
import com.huggin.app.extractors.DoodWatchExtractor
import com.huggin.app.extractors.DoodWfExtractor
import com.huggin.app.extractors.DoodWsExtractor
import com.huggin.app.extractors.DoodYtExtractor
import com.huggin.app.extractors.Doodspro
import com.huggin.app.extractors.Dsvplay
import com.huggin.app.extractors.Doodporn
import com.huggin.app.extractors.DoodstreamCom
import com.huggin.app.extractors.Dooood
import com.huggin.app.extractors.Ds2play
import com.huggin.app.extractors.Ds2video
import com.huggin.app.extractors.DsstOnline
import com.huggin.app.extractors.Dumbalag
import com.huggin.app.extractors.Dwish
import com.huggin.app.extractors.Embedgram
import com.huggin.app.extractors.EmturbovidExtractor
import com.huggin.app.extractors.Evoload
import com.huggin.app.extractors.Evoload1
import com.huggin.app.extractors.Ewish
import com.huggin.app.extractors.FEmbed
import com.huggin.app.extractors.FEnet
import com.huggin.app.extractors.Fastream
import com.huggin.app.extractors.FeHD
import com.huggin.app.extractors.Fembed9hd
import com.huggin.app.extractors.FileMoon
import com.huggin.app.extractors.FileMoonIn
import com.huggin.app.extractors.FileMoonSx
import com.huggin.app.extractors.FilemoonV2
import com.huggin.app.extractors.Filesim
import com.huggin.app.extractors.Firestream
import com.huggin.app.extractors.FirestreamSite
import com.huggin.app.extractors.Multimoviesshg
import com.huggin.app.extractors.FlaswishCom
import com.huggin.app.extractors.Flyfile
import com.huggin.app.extractors.FourCX
import com.huggin.app.extractors.FourPichive
import com.huggin.app.extractors.FourPlayRu
import com.huggin.app.extractors.Fplayer
import com.huggin.app.extractors.FsstOnline
import com.huggin.app.extractors.GDMirrorbot
import com.huggin.app.extractors.GUpload
import com.huggin.app.extractors.GamoVideo
import com.huggin.app.extractors.Gdriveplayer
import com.huggin.app.extractors.Gdriveplayerapi
import com.huggin.app.extractors.Gdriveplayerapp
import com.huggin.app.extractors.Gdriveplayerbiz
import com.huggin.app.extractors.Gdriveplayerco
import com.huggin.app.extractors.Gdriveplayerfun
import com.huggin.app.extractors.Gdriveplayerio
import com.huggin.app.extractors.Gdriveplayerme
import com.huggin.app.extractors.Gdriveplayerorg
import com.huggin.app.extractors.Gdriveplayerus
import com.huggin.app.extractors.Geodailymotion
import com.huggin.app.extractors.Gofile
import com.huggin.app.extractors.GoodstreamExtractor
import com.huggin.app.extractors.Guccihide
import com.huggin.app.extractors.Guxhag
import com.huggin.app.extractors.HDMomPlayer
import com.huggin.app.extractors.HDPlayerSystem
import com.huggin.app.extractors.HDStreamAble
import com.huggin.app.extractors.Habetar
import com.huggin.app.extractors.Handfacesnap
import com.huggin.app.extractors.Haxloppd
import com.huggin.app.extractors.Hexload
import com.huggin.app.extractors.Hgcloudto
import com.huggin.app.extractors.HglinkTo
import com.huggin.app.extractors.HgplayCDN
import com.huggin.app.extractors.Hotlinger
import com.huggin.app.extractors.HubCloud
import com.huggin.app.extractors.Hxfile
import com.huggin.app.extractors.HlsWish
import com.huggin.app.extractors.HubuCloud
import com.huggin.app.extractors.InternetArchive
import com.huggin.app.extractors.JWPlayer
import com.huggin.app.extractors.Jeniusplay
import com.huggin.app.extractors.Jodwish
import com.huggin.app.extractors.Keephealth
import com.huggin.app.extractors.KotakAnimeid
import com.huggin.app.extractors.Kotakajair
import com.huggin.app.extractors.Krakenfiles
import com.huggin.app.extractors.Kswplayer
import com.huggin.app.extractors.LayarKaca
import com.huggin.app.extractors.Linkbox
import com.huggin.app.extractors.LuluStream
import com.huggin.app.extractors.Lulustream1
import com.huggin.app.extractors.Lulustream2
import com.huggin.app.extractors.Luluvdoo
import com.huggin.app.extractors.Luxubu
import com.huggin.app.extractors.Lvturbo
import com.huggin.app.extractors.MailRu
import com.huggin.app.extractors.Maxstream
import com.huggin.app.extractors.Mediafire
import com.huggin.app.extractors.Megacloud
import com.huggin.app.extractors.Meownime
import com.huggin.app.extractors.MetaGnathTuggers
import com.huggin.app.extractors.MixDrop
import com.huggin.app.extractors.MixDropAg
import com.huggin.app.extractors.MixDropBz
import com.huggin.app.extractors.MixDropCh
import com.huggin.app.extractors.MixDropTo
import com.huggin.app.extractors.MixDropPs
import com.huggin.app.extractors.Mdy
import com.huggin.app.extractors.MixDropSi
import com.huggin.app.extractors.MxDropTo
import com.huggin.app.extractors.Movhide
import com.huggin.app.extractors.Moviehab
import com.huggin.app.extractors.MoviehabNet
import com.huggin.app.extractors.Moviesm4u
import com.huggin.app.extractors.Mp4Upload
import com.huggin.app.extractors.Multimovies
import com.huggin.app.extractors.Mvidoo
import com.huggin.app.extractors.MyVidPlay
import com.huggin.app.extractors.Mwish
import com.huggin.app.extractors.Namefacesnap
import com.huggin.app.extractors.Nameitweb
import com.huggin.app.extractors.NathanFromSubject
import com.huggin.app.extractors.Nekostream
import com.huggin.app.extractors.Nekowish
import com.huggin.app.extractors.Neonime7n
import com.huggin.app.extractors.Neonime8n
import com.huggin.app.extractors.Obeywish
import com.huggin.app.extractors.Odnoklassniki
import com.huggin.app.extractors.Odysseusa
import com.huggin.app.extractors.OkRuHTTP
import com.huggin.app.extractors.OkRuHTTPMobile
import com.huggin.app.extractors.OkRuSSL
import com.huggin.app.extractors.OkRuSSLMobile
import com.huggin.app.extractors.PeaceMakerst
import com.huggin.app.extractors.Peytonepre
import com.huggin.app.extractors.Pichive
import com.huggin.app.extractors.PixelDrain
import com.huggin.app.extractors.PixelDrainDev
import com.huggin.app.extractors.PlayLtXyz
import com.huggin.app.extractors.PlayRu
import com.huggin.app.extractors.PlayerVoxzer
import com.huggin.app.extractors.Playerwish
import com.huggin.app.extractors.Playmate
import com.huggin.app.extractors.Playmogo
import com.huggin.app.extractors.Rabbitstream
import com.huggin.app.extractors.RapidVid
import com.huggin.app.extractors.Rasacintaku
import com.huggin.app.extractors.SBfull
import com.huggin.app.extractors.Sbasian
import com.huggin.app.extractors.Sbface
import com.huggin.app.extractors.Sbflix
import com.huggin.app.extractors.Sblona
import com.huggin.app.extractors.Sblongvu
import com.huggin.app.extractors.Sbnet
import com.huggin.app.extractors.Sbrapid
import com.huggin.app.extractors.Sbsonic
import com.huggin.app.extractors.Sbspeed
import com.huggin.app.extractors.Sbthe
import com.huggin.app.extractors.SecvideoOnline
import com.huggin.app.extractors.Sendvid
import com.huggin.app.extractors.Server1uns
import com.huggin.app.extractors.SfastwishCom
import com.huggin.app.extractors.ShaveTape
import com.huggin.app.extractors.SibNet
import com.huggin.app.extractors.Simpulumlamerop
import com.huggin.app.extractors.Smoothpre
import com.huggin.app.extractors.Sobreatsesuyp
import com.huggin.app.extractors.Ssbstream
import com.huggin.app.extractors.StreamEmbed
import com.huggin.app.extractors.StreamHLS
import com.huggin.app.extractors.StreamM4u
import com.huggin.app.extractors.StreamSB
import com.huggin.app.extractors.StreamSB1
import com.huggin.app.extractors.StreamSB10
import com.huggin.app.extractors.StreamSB11
import com.huggin.app.extractors.StreamSB2
import com.huggin.app.extractors.StreamSB3
import com.huggin.app.extractors.StreamSB4
import com.huggin.app.extractors.StreamSB5
import com.huggin.app.extractors.StreamSB6
import com.huggin.app.extractors.StreamSB7
import com.huggin.app.extractors.StreamSB8
import com.huggin.app.extractors.StreamSB9
import com.huggin.app.extractors.StreamSilk
import com.huggin.app.extractors.StreamTape
import com.huggin.app.extractors.StreamTapeNet
import com.huggin.app.extractors.StreamTapeXyz
import com.huggin.app.extractors.Watchadsontape
import com.huggin.app.extractors.StreamWishExtractor
import com.huggin.app.extractors.StreamhideCom
import com.huggin.app.extractors.StreamhideTo
import com.huggin.app.extractors.Streamhub2
import com.huggin.app.extractors.Streamlare
import com.huggin.app.extractors.StreamoUpload
import com.huggin.app.extractors.Streamplay
import com.huggin.app.extractors.Streamsss
import com.huggin.app.extractors.Streamwish2
import com.huggin.app.extractors.Strwish
import com.huggin.app.extractors.Strwish2
import com.huggin.app.extractors.Supervideo
import com.huggin.app.extractors.Swdyu
import com.huggin.app.extractors.Swhoi
import com.huggin.app.extractors.TRsTX
import com.huggin.app.extractors.Tantifilm
import com.huggin.app.extractors.TauVideo
import com.huggin.app.extractors.Techinmind
import com.huggin.app.extractors.Tubeless
import com.huggin.app.extractors.Uasopt
import com.huggin.app.extractors.Up4FunTop
import com.huggin.app.extractors.Up4Stream
import com.huggin.app.extractors.Upstream
import com.huggin.app.extractors.UpstreamExtractor
import com.huggin.app.extractors.Uqload
import com.huggin.app.extractors.Uqload1
import com.huggin.app.extractors.Uqload2
import com.huggin.app.extractors.Uqloadcx
import com.huggin.app.extractors.Uqloadbz
import com.huggin.app.extractors.UqloadsXyz
import com.huggin.app.extractors.Urochsunloath
import com.huggin.app.extractors.Userload
import com.huggin.app.extractors.Userscloud
import com.huggin.app.extractors.Uservideo
import com.huggin.app.extractors.Videa
import com.huggin.app.extractors.Vicloud
import com.huggin.app.extractors.VidHidePro
import com.huggin.app.extractors.VidHidePro1
import com.huggin.app.extractors.VidHidePro2
import com.huggin.app.extractors.VidHidePro3
import com.huggin.app.extractors.VidHidePro4
import com.huggin.app.extractors.VidHidePro5
import com.huggin.app.extractors.VidHidePro6
import com.huggin.app.extractors.VidHideHub
import com.huggin.app.extractors.Ryderjet
import com.huggin.app.extractors.Streamcash
import com.huggin.app.extractors.Thebesthostertv
import com.huggin.app.extractors.VidChampions
import com.huggin.app.extractors.VidMoxy
import com.huggin.app.extractors.VidStack
import com.huggin.app.extractors.VideoSeyred
import com.huggin.app.extractors.Videzz
import com.huggin.app.extractors.Vidgomunime
import com.huggin.app.extractors.Vidgomunimesb
import com.huggin.app.extractors.VidhideExtractor
import com.huggin.app.extractors.Vidmoly
import com.huggin.app.extractors.Vidmolyme
import com.huggin.app.extractors.Vidmolyto
import com.huggin.app.extractors.Vidmolybiz
import com.huggin.app.extractors.Vido
import com.huggin.app.extractors.Vidoza
import com.huggin.app.extractors.VinovoSi
import com.huggin.app.extractors.VinovoTo
import com.huggin.app.extractors.VidNest
import com.huggin.app.extractors.VidaaraxCom
import com.huggin.app.extractors.VidaaraxNet
import com.huggin.app.extractors.Vidara
import com.huggin.app.extractors.VidaraSo
import com.huggin.app.extractors.Vidaraa
import com.huggin.app.extractors.Vidaratem
import com.huggin.app.extractors.Vidaraw
import com.huggin.app.extractors.Vidarax
import com.huggin.app.extractors.Vidavaca
import com.huggin.app.extractors.Vide0Net
import com.huggin.app.extractors.Vidmatrixa
import com.huggin.app.extractors.Vids
import com.huggin.app.extractors.Vidsonic
import com.huggin.app.extractors.Vixeo
import com.huggin.app.extractors.VkExtractor
import com.huggin.app.extractors.Voe
import com.huggin.app.extractors.Voe1
import com.huggin.app.extractors.Voe2
import com.huggin.app.extractors.Vtbe
import com.huggin.app.extractors.Wibufile
import com.huggin.app.extractors.WishembedPro
import com.huggin.app.extractors.Wishfast
import com.huggin.app.extractors.Wishonly
import com.huggin.app.extractors.XStreamCdn
import com.huggin.app.extractors.Xenolyzb
import com.huggin.app.extractors.Yipsu
import com.huggin.app.extractors.YourUpload
import com.huggin.app.extractors.YoutubeExtractor
import com.huggin.app.extractors.YoutubeMobileExtractor
import com.huggin.app.extractors.YoutubeNoCookieExtractor
import com.huggin.app.extractors.YoutubeShortLinkExtractor
import com.huggin.app.extractors.Yufiles
import com.huggin.app.extractors.Yuguaab
import com.huggin.app.extractors.Zplayer
import com.huggin.app.extractors.ZplayerV2
import com.huggin.app.extractors.Ztreamhub
import com.huggin.app.mvvm.logError
import com.huggin.app.utils.Coroutines.atomicListOf
import io.ktor.http.Url
import io.ktor.http.decodeURLPart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.coroutines.cancellation.CancellationException
import kotlin.uuid.Uuid
import kotlin.uuid.toJavaUuid
import kotlin.uuid.toKotlinUuid

/**
 * For use in the ConcatenatingMediaSource.
 * If features are missing (headers), please report and we can add it.
 * @param durationUs use Long.toUs() for easier input
 * */
data class PlayListItem(
    val url: String,
    val durationUs: Long,
)

/**
 * Converts Seconds to MicroSeconds, multiplication by 1_000_000
 * */
fun Long.toUs(): Long {
    return this * 1_000_000
}

/**
 * If your site has an unorthodox m3u8-like system where there are multiple smaller videos concatenated
 * use this.
 * */
@Suppress("DEPRECATION")
data class ExtractorLinkPlayList(
    override val source: String,
    override val name: String,
    val playlist: List<PlayListItem>,
    override var referer: String,
    override var quality: Int,
    override var headers: Map<String, String> = mapOf(),
    /** Used for getExtractorVerifierJob() */
    override var extractorData: String? = null,
    override var type: ExtractorLinkType,
    override var audioTracks: List<AudioFile> = emptyList(),
) : ExtractorLink(
    source = source,
    name = name,
    url = "",
    referer = referer,
    quality = quality,
    headers = headers,
    extractorData = extractorData,
    type = type,
    audioTracks = audioTracks
) {
    constructor(
        source: String,
        name: String,
        playlist: List<PlayListItem>,
        referer: String,
        quality: Int,
        isM3u8: Boolean = false,
        headers: Map<String, String> = mapOf(),
        extractorData: String? = null,
    ) : this(
        source = source,
        name = name,
        playlist = playlist,
        referer = referer,
        quality = quality,
        type = if (isM3u8) ExtractorLinkType.M3U8 else ExtractorLinkType.VIDEO,
        headers = headers,
        extractorData = extractorData,
    )
}

/** Metadata about the file type used for downloads and exoplayer hint,
 * if you respond with the wrong one the file will fail to download or be played */
enum class ExtractorLinkType {
    /** Single stream of bytes no matter the actual file type */
    VIDEO,

    /** Split into several .ts files, has support for encrypted m3u8s */
    M3U8,

    /** Like m3u8 but uses xml, currently no download support */
    DASH,

    /** No support at the moment */
    TORRENT,

    /** No support at the moment */
    MAGNET;

    // See https://www.iana.org/assignments/media-types/media-types.xhtml
    @JsonIgnore
    fun getMimeType(): String {
        return when (this) {
            VIDEO -> "video/mp4"
            M3U8 -> "application/x-mpegURL"
            DASH -> "application/dash+xml"
            TORRENT -> "application/x-bittorrent"
            MAGNET -> "application/x-bittorrent"
        }
    }
}

private fun inferTypeFromUrl(url: String): ExtractorLinkType {
    val path = try {
        Url(url).encodedPath.decodeURLPart()
    } catch (_: Throwable) {
        // don't log magnet links as errors
        null
    }
    return when {
        path?.endsWith(".m3u8") == true -> ExtractorLinkType.M3U8
        path?.endsWith(".mpd") == true -> ExtractorLinkType.DASH
        path?.endsWith(".torrent") == true -> ExtractorLinkType.TORRENT
        url.startsWith("magnet:") -> ExtractorLinkType.MAGNET
        else -> ExtractorLinkType.VIDEO
    }
}

val INFER_TYPE: ExtractorLinkType? = null

/**
 * [Uuid] for the ClearKey DRM scheme.
 *
 *
 * ClearKey is supported on Android devices running Android 5.0 (API Level 21) and up.
 */
val CLEARKEY_DRM_UUID = Uuid.fromLongs(-0x1d8e62a7567a4c37L, 0x781AB030AF78D30EL)

/**
 * [Uuid] for the Widevine DRM scheme.
 *
 *
 * Widevine is supported on Android devices running Android 4.3 (API Level 18) and up.
 */
val WIDEVINE_DRM_UUID = Uuid.fromLongs(-0x121074568629b532L, -0x5c37d8232ae2de13L)

/**
 * [Uuid] for the PlayReady DRM scheme.
 *
 *
 * PlayReady is supported on all AndroidTV devices. Note that most other Android devices do not
 * provide PlayReady support.
 */
val PLAYREADY_DRM_UUID = Uuid.fromLongs(-0x65fb0f8667bfbd7aL, -0x546d19a41f77a06bL)

// Deprecate after next stable

// @Deprecated("Use CLEARKEY_DRM_UUID", ReplaceWith("CLEARKEY_DRM_UUID"), level = DeprecationLevel.WARNING)
val CLEARKEY_UUID = CLEARKEY_DRM_UUID.toJavaUuid()

// @Deprecated("Use WIDEVINE_DRM_UUID", ReplaceWith("WIDEVINE_DRM_UUID"), level = DeprecationLevel.WARNING)
val WIDEVINE_UUID = WIDEVINE_DRM_UUID.toJavaUuid()

// @Deprecated("Use PLAYREADY_DRM_UUID", ReplaceWith("PLAYREADY_DRM_UUID"), level = DeprecationLevel.WARNING)
val PLAYREADY_UUID = PLAYREADY_DRM_UUID.toJavaUuid()

suspend fun newExtractorLink(
    source: String,
    name: String,
    url: String,
    type: ExtractorLinkType? = null,
    initializer: suspend ExtractorLink.() -> Unit = { }
): ExtractorLink {

    @Suppress("DEPRECATION_ERROR")
    val builder =
        ExtractorLink(
            source = source,
            name = name,
            url = url,
            type = type ?: INFER_TYPE
        )

    builder.initializer()
    return builder
}

// Deprecate after next stable
/* @Deprecated(
    message = "Use Kotlin Uuid (kotlin.uuid.Uuid) instead of Java UUID.",
    level = DeprecationLevel.WARNING,
) */
suspend fun newDrmExtractorLink(
    source: String,
    name: String,
    url: String,
    type: ExtractorLinkType? = null,
    uuid: java.util.UUID,
    initializer: suspend DrmExtractorLink.() -> Unit = { }
): DrmExtractorLink {
    @Suppress("DEPRECATION_ERROR")
    val builder =
        DrmExtractorLink(
            source = source,
            name = name,
            url = url,
            uuid = uuid.toKotlinUuid(),
            type = type ?: INFER_TYPE
        )

    builder.initializer()
    return builder
}

suspend fun newDrmExtractorLink(
    source: String,
    name: String,
    url: String,
    type: ExtractorLinkType? = null,
    uuid: Uuid,
    initializer: suspend DrmExtractorLink.() -> Unit = {},
): DrmExtractorLink {
    @Suppress("DEPRECATION_ERROR")
    val builder =
        DrmExtractorLink(
            source = source,
            name = name,
            url = url,
            uuid = uuid,
            type = type ?: INFER_TYPE
        )

    builder.initializer()
    return builder
}

/** Class holds extracted DRM media info to be passed to the player.
 * @property source Name of the media source, appears on player layout.
 * @property name Title of the media, appears on player layout.
 * @property url Url string of media file
 * @property referer Referer that will be used by network request.
 * @property quality Quality of the media file
 * @property headers Headers <String, String> map that will be used by network request.
 * @property extractorData Used for getExtractorVerifierJob()
 * @property type the type of the media, use [INFER_TYPE] if you want to auto infer the type from the url
 * @property kid  Base64 value of The KID element (Key Id) contains the identifier of the key associated with a license.
 * @property key Base64 value of Key to be used to decrypt the media file.
 * @property uuid Drm [Uuid] [WIDEVINE_DRM_UUID], [PLAYREADY_DRM_UUID], [CLEARKEY_DRM_UUID] (by default) .. etc
 * @property kty Key type "oct" (octet sequence) by default
 * @property keyRequestParameters Parameters that will used to request the key.
 * @see newDrmExtractorLink
 * */
@Suppress("DEPRECATION")
open class DrmExtractorLink private constructor(
    override val source: String,
    override val name: String,
    override val url: String,
    override var referer: String,
    override var quality: Int,
    override var headers: Map<String, String> = mapOf(),
    /** Used for getExtractorVerifierJob() */
    override var extractorData: String? = null,
    override var type: ExtractorLinkType,
    open var kid: String? = null,
    open var key: String? = null,
    open var uuid: Uuid,
    open var kty: String? = null,
    open var keyRequestParameters: HashMap<String, String>,
    open var licenseUrl: String? = null,
    override var audioTracks: List<AudioFile> = emptyList(),
) : ExtractorLink(
    source, name, url, referer, quality, headers, extractorData, type, audioTracks
) {
    @Deprecated("Use newDrmExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String? = null,
        quality: Int? = null,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType? = INFER_TYPE,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
        kid: String? = null,
        key: String? = null,
        uuid: Uuid = CLEARKEY_DRM_UUID,
        kty: String? = "oct",
        keyRequestParameters: HashMap<String, String> = hashMapOf(),
        licenseUrl: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer ?: "",
        quality = quality ?: Qualities.Unknown.value,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url),
        kid = kid,
        key = key,
        uuid = uuid,
        keyRequestParameters = keyRequestParameters,
        kty = kty,
        licenseUrl = licenseUrl,
    )

    @Deprecated("Use newDrmExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType?,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
        kid: String? = null,
        key: String? = null,
        uuid: Uuid = CLEARKEY_DRM_UUID,
        kty: String? = "oct",
        keyRequestParameters: HashMap<String, String> = hashMapOf(),
        licenseUrl: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer,
        quality = quality,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url),
        kid = kid,
        key = key,
        uuid = uuid,
        keyRequestParameters = keyRequestParameters,
        kty = kty,
        licenseUrl = licenseUrl,
    )

    @Deprecated(message = "Use Kotlin Uuid", level = DeprecationLevel.HIDDEN)
    fun setUuid(uuid: java.util.UUID) {
        this.uuid = uuid.toKotlinUuid()
    }

    @Deprecated(message = "Use Kotlin Uuid", level = DeprecationLevel.HIDDEN)
    fun getUuid(): java.util.UUID = this.uuid.toJavaUuid()
}

/** Class holds extracted media info to be passed to the player.
 * @property source Name of the media source, appears on player layout.
 * @property name Title of the media, appears on player layout.
 * @property url Url string of media file
 * @property referer Referer that will be used by network request.
 * @property quality Quality of the media file
 * @property headers Headers <String, String> map that will be used by network request.
 * @property extractorData Used for getExtractorVerifierJob()
 * @property type Extracted link type (Video, M3u8, Dash, Torrent or Magnet)
 * @property audioTracks List of separate audio tracks that can be used with this video
 * @see newExtractorLink
 * */
@Serializable
open class ExtractorLink
@Deprecated("Use newExtractorLink", level = DeprecationLevel.WARNING)
constructor(
    @SerialName("source") open val source: String,
    @SerialName("name") open val name: String,
    @SerialName("url") override val url: String,
    @SerialName("referer") override var referer: String,
    @SerialName("quality") open var quality: Int,
    @SerialName("headers") override var headers: Map<String, String> = mapOf(),
    /** Used for getExtractorVerifierJob() */
    @SerialName("extractorData") open var extractorData: String? = null,
    @SerialName("type") open var type: ExtractorLinkType,
    /** List of separate audio tracks that can be merged with this video */
    @SerialName("audioTracks") open var audioTracks: List<AudioFile> = emptyList(),
) : IDownloadableMinimum {
    @get:JsonIgnore val isM3u8: Boolean get() = type == ExtractorLinkType.M3U8
    @get:JsonIgnore val isDash: Boolean get() = type == ExtractorLinkType.DASH

    // Cached video size
    @Transient private var videoSize: Long? = null

    /**
     * Get video size in bytes with one head request. Only available for ExtractorLinkType.Video
     * @param timeoutSeconds timeout of the head request.
     */
    suspend fun getVideoSize(timeoutSeconds: Long = 3L): Long? {
        // Content-Length is not applicable to other types of formats
        if (this.type != ExtractorLinkType.VIDEO) return null

        videoSize = videoSize ?: runCatching {
            val response =
                app.head(this.url, headers = headers, referer = referer, timeout = timeoutSeconds)
            response.headers["Content-Length"]?.toLong()
        }.getOrNull()

        return videoSize
    }

    @JsonIgnore
    fun getAllHeaders(): Map<String, String> {
        if (referer.isBlank()) {
            return headers
        } else if (headers.keys.none { it.equals("referer", ignoreCase = true) }) {
            return headers + mapOf("referer" to referer)
        }
        return headers
    }

    @Suppress("DEPRECATION")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String? = null,
        quality: Int? = null,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType? = INFER_TYPE,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer ?: "",
        quality = quality ?: Qualities.Unknown.value,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url)
    )

    @Suppress("DEPRECATION")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType?,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer,
        quality = quality,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url)
    )

    /**
     * Old constructor without isDash, allows for backwards compatibility with extensions.
     * Should be removed after all extensions have updated their huggin.jar
     **/
    @Suppress("DEPRECATION_ERROR")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        isM3u8: Boolean = false,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null
    ) : this(source, name, url, referer, quality, isM3u8, headers, extractorData, false)

    @Suppress("DEPRECATION")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        isM3u8: Boolean = false,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
        isDash: Boolean,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer,
        quality = quality,
        headers = headers,
        extractorData = extractorData,
        type = if (isDash) ExtractorLinkType.DASH else if (isM3u8) ExtractorLinkType.M3U8 else ExtractorLinkType.VIDEO
    )

    override fun toString(): String {
        return "ExtractorLink(name=$name, url=$url, referer=$referer, type=$type)"
    }
}

/**
 * Removes https:// and www.
 * To match urls regardless of schema, perhaps Url() can be used?
 */
val schemaStripRegex = Regex("""^(https:|)//(www\.|)""")

enum class Qualities(var value: Int, val defaultPriority: Int) {
    Unknown(400, 4),
    P144(144, 0), // 144p
    P240(240, 2), // 240p
    P360(360, 3), // 360p
    P480(480, 4), // 480p
    P720(720, 5), // 720p
    P1080(1080, 6), // 1080p
    P1440(1440, 7), // 1440p
    P2160(2160, 8); // 4k or 2160p

    companion object {
        fun getStringByInt(qual: Int?): String {
            return when (qual) {
                0 -> "Auto"
                Unknown.value -> ""
                P2160.value -> "4K"
                null -> ""
                else -> "${qual}p"
            }
        }

        fun getStringByIntFull(quality: Int): String {
            return when (quality) {
                0 -> "Auto"
                Unknown.value -> "Unknown"
                P2160.value -> "4K"
                else -> "${quality}p"
            }
        }
    }
}

fun getQualityFromName(qualityName: String?): Int {
    if (qualityName == null)
        return Qualities.Unknown.value

    val match = qualityName.lowercase().replace("p", "").trim()
    return when (match) {
        "4k" -> Qualities.P2160
        else -> null
    }?.value ?: match.toIntOrNull() ?: Qualities.Unknown.value
}

private val packedRegex = Regex("""eval\(function\(p,a,c,k,e,.*\)\)""")
fun getPacked(string: String): String? {
    return packedRegex.find(string)?.value
}

fun getAndUnpack(string: String): String {
    val packedText = getPacked(string)
    return JsUnpacker(packedText).unpack() ?: string
}

suspend fun unshortenLinkSafe(url: String): String {
    return try {
        if (ShortLink.isShortLink(url))
            ShortLink.unshorten(url)
        else url
    } catch (e: Exception) {
        logError(e)
        url
    }
}

suspend fun loadExtractor(
    url: String,
    subtitleCallback: (SubtitleFile) -> Unit,
    callback: (ExtractorLink) -> Unit
): Boolean {
    return loadExtractor(
        url = url,
        referer = null,
        subtitleCallback = subtitleCallback,
        callback = callback
    )
}


/**
 * Tries to load the appropriate extractor based on link, returns true if any extractor is loaded.
 * */
@Throws(CancellationException::class)
suspend fun loadExtractor(
    url: String,
    referer: String? = null,
    subtitleCallback: (SubtitleFile) -> Unit,
    callback: (ExtractorLink) -> Unit
): Boolean {
    // Ensure this coroutine has not timed out
    coroutineScope { ensureActive() }

    val currentUrl = unshortenLinkSafe(url)
    val compareUrl = currentUrl.lowercase().replace(schemaStripRegex, "")

    // Iterate in reverse order so the new registered ExtractorApi takes priority
    for (index in extractorApis.lastIndex downTo 0) {
        val extractor = extractorApis[index]
        if (compareUrl.startsWith(extractor.mainUrl.replace(schemaStripRegex, ""))) {
            try {
                extractor.getUrl(currentUrl, referer, subtitleCallback, callback)
            } catch (e: Exception) {
                logError(e)
                // Rethrow if we have timed out
                if (e is CancellationException) {
                    throw e
                }
            }
            return true
        }
    }

    // this is to match mirror domains - like example.com, example.net
    for (index in extractorApis.lastIndex downTo 0) {
        val extractor = extractorApis[index]
        if (Levenshtein.partialRatio(
                extractor.mainUrl,
                currentUrl
            ) > 80
        ) {
            try {
                extractor.getUrl(currentUrl, referer, subtitleCallback, callback)
            } catch (e: Exception) {
                logError(e)
                // Rethrow if we have timed out
                if (e is CancellationException) {
                    throw e
                }
            }
            return true
        }
    }

    return false
}

val extractorApis: AtomicMutableList<ExtractorApi> = atomicListOf(
    //AllProvider(),
    Mp4Upload(),
    StreamTape(),
    StreamTapeNet(),
    ShaveTape(),
    StreamTapeXyz(),
    Watchadsontape(),

    //mixdrop extractors
    MixDropBz(),
    MixDropCh(),
    MixDropTo(),
    MixDropAg(),
    MixDrop(),
    MixDropPs(),
    Mdy(),
    MxDropTo(),
    MixDropSi(),

    XStreamCdn(),

    StreamSB(),
    Sblona(),
    Vidgomunimesb(),
    StreamSilk(),
    StreamSB1(),
    StreamSB2(),
    StreamSB3(),
    StreamSB4(),
    StreamSB5(),
    StreamSB6(),
    StreamSB7(),
    StreamSB8(),
    StreamSB9(),
    StreamSB10(),
    StreamSB11(),
    SBfull(),
    // Streamhub(), cause Streamhub2() works
    Streamhub2(),
    Ssbstream(),
    Sbthe(),
    Vidgomunime(),
    Sbflix(),
    Streamsss(),
    Sbspeed(),
    Sbsonic(),
    Sbface(),
    Sbrapid(),
    Lvturbo(),

    Fastream(),
    Videa(),
    FEmbed(),
    FeHD(),
    Fplayer(),
    DBfilm(),
    Luxubu(),
    LayarKaca(),
    Rasacintaku(),
    FEnet(),
    Kotakajair(),
    Cdnplayer(),
    //  WatchSB(), 'cause StreamSB.kt works
    Uqload(),
    Uqload1(),
    Uqload2(),
    Uqloadcx(),
    Uqloadbz(),
    Evoload(),
    Evoload1(),
    UpstreamExtractor(),

    Odnoklassniki(),
    TauVideo(),
    SibNet(),
    ContentX(),
    Hotlinger(),
    FourCX(),
    PlayRu(),
    FourPlayRu(),
    Pichive(),
    FourPichive(),
    HDMomPlayer(),
    HDPlayerSystem(),
    VideoSeyred(),
    PeaceMakerst(),
    HDStreamAble(),
    RapidVid(),
    TRsTX(),
    VidMoxy(),
    Sobreatsesuyp(),
    PixelDrain(),
    PixelDrainDev(),
    MailRu(),

    OkRuSSL(),
    OkRuSSLMobile(),
    OkRuHTTP(),
    OkRuHTTPMobile(),
    Sendvid(),

    // dood extractors
    DoodCxExtractor(),
    DoodPmExtractor(),
    DoodToExtractor(),
    DoodSoExtractor(),
    DoodLaExtractor(),
    Dooood(),
    D0000d(),
    D000dCom(),
    DoodstreamCom(),
    DoodWsExtractor(),
    DoodShExtractor(),
    DoodWatchExtractor(),
    DoodWfExtractor(),
    DoodYtExtractor(),
    Doodspro(),
    Dsvplay(),

    // GenericM3U8(),
    Zplayer(),
    ZplayerV2(),
    Upstream(),

    Maxstream(),
    Tantifilm(),
    Userload(),
    Supervideo(),
    Streamcash(),

    // StreamSB.kt works
    //  SBPlay(),
    //  SBPlay1(),
    //  SBPlay2(),

    PlayerVoxzer(),

    Blogger(),
    YourUpload(),

    Hxfile(),
    KotakAnimeid(),
    Neonime8n(),
    Neonime7n(),
    Yufiles(),
    Aico(),

    JWPlayer(),
    Meownime(),
    DesuArcg(),
    DesuOdchan(),
    DesuOdvip(),
    DesuDrive(),


    Keephealth(),
    Sbnet(),
    Sbasian(),
    Sblongvu(),
    Fembed9hd(),
    StreamM4u(),
    Krakenfiles(),
    Gofile(),
    Vicloud(),
    Uservideo(),
    Userscloud(),
    HubuCloud(),

    Movhide(),
    StreamhideCom(),
    StreamhideTo(),
    Wibufile(),
    FileMoonIn(),
    Moviesm4u(),
    Filesim(),
    Multimoviesshg(),
    Ahvsh(),
    Guccihide(),
    FileMoon(),
    FileMoonSx(),
    FilemoonV2(),

    Vido(),
    Linkbox(),
    Acefile(),
    Embedgram(),
    Mvidoo(),
    Streamplay(),
    Vidmoly(),
    Vidmolyme(),
    Vidmolyto(),
    Vidmolybiz(),
    Voe(),
    Voe1(),
    Voe2(),
    Tubeless(),
    Moviehab(),
    MoviehabNet(),
    Jeniusplay(),
    StreamoUpload(),
    Vidara(),
    Vidavaca(),
    Vidaraa(),
    Vidaraw(),
    Vidarax(),
    VidaraSo(),
    Vidaratem(),
    VidaaraxCom(),
    VidaaraxNet(),
    Odysseusa(),
    Handfacesnap(),
    Namefacesnap(),
    Thebesthostertv(),
    Vidmatrixa(),
    VidChampions(),
    Antarcticadocs(),
    Nameitweb(),

    GamoVideo(),
    Gdriveplayerapi(),
    Gdriveplayerapp(),
    Gdriveplayerfun(),
    Gdriveplayerio(),
    Gdriveplayerme(),
    Gdriveplayerbiz(),
    Gdriveplayerorg(),
    Gdriveplayerus(),
    Gdriveplayerco(),
    GoodstreamExtractor(),
    Gdriveplayer(),
    DatabaseGdrive(),
    DatabaseGdrive2(),
    Mediafire(),

    YoutubeExtractor(),
    YoutubeShortLinkExtractor(),
    YoutubeMobileExtractor(),
    YoutubeNoCookieExtractor(),
    Streamlare(),
    PlayLtXyz(),

    Cda(),
    Dailymotion(),
    Ztreamhub(),
    Rabbitstream(),
    Dokicloud(),
    Megacloud(),
    VidhideExtractor(),
    VidHidePro(),
    VidHidePro1(),
    VidHidePro2(),
    VidHidePro3(),
    VidHidePro4(),
    VidHidePro5(),
    VidHidePro6(),
    VidHideHub(),
    Ryderjet(),
    VidNest(),
    Dhtpre(),

    // CineMM Redirects
    Dhcplay(),
    HglinkTo(),

    // CineMM mirrors
    HgplayCDN(),
    Habetar(),
    Yuguaab(),
    Guxhag(),
    Auvexiug(),
    Xenolyzb(),
    Haxloppd(),
    Cavanhabg(),
    Dumbalag(),
    Uasopt(),

    Smoothpre(),
    Peytonepre(),
    LuluStream(),
    Lulustream1(),
    Lulustream2(),
    Luluvdoo(),
    StreamWishExtractor(),
    StreamHLS(),
    BigwarpIO(),
    BigwarpArt(),
    BgwpCC(),
    WishembedPro(),
    CdnwishCom(),
    FlaswishCom(),
    SfastwishCom(),
    Playerwish(),
    StreamEmbed(),
    EmturbovidExtractor(),
    Vtbe(),
    SecvideoOnline(),
    FsstOnline(),
    CsstOnline(),
    DsstOnline(),
    Simpulumlamerop(),
    Urochsunloath(),
    NathanFromSubject(),
    Yipsu(),
    MetaGnathTuggers(),
    Geodailymotion(),
    Mwish(),
    Hgcloudto(),
    Dwish(),
    Ewish(),
    Kswplayer(),
    Wishfast(),
    Streamwish2(),
    Strwish(),
    Strwish2(),
    Awish(),
    Obeywish(),
    Jodwish(),
    Swhoi(),
    Multimovies(),
    UqloadsXyz(),
    Doodporn(),
    Asnwish(),
    Nekowish(),
    Nekostream(),
    Swdyu(),
    Wishonly(),
    Ds2play(),
    Ds2video(),
    Vidsonic(),
    Vixeo(),
    InternetArchive(),
    VidStack(),
    GDMirrorbot(),
    Techinmind(),
    Server1uns(),
    VinovoSi(),
    VinovoTo(),
    Vidoza(),
    Videzz(),
    CloudMailRu(),
    HubCloud(),
    VkExtractor(),
    Bysezejataos(),
    ByseSX(),
    ByseVepoin(),
    ByseBuho(),
    MyVidPlay(),
    Playmogo(),
    Vide0Net(),
    Up4Stream(),
    Up4FunTop(),
    GUpload(),
    HlsWish(),
    ByseQekaho(),
    Flyfile(),
    Firestream(),
    FirestreamSite(),
    Vids(),
    Playmate(),
    Hexload(),
)


fun getExtractorApiFromName(name: String): ExtractorApi {
    for (api in extractorApis) {
        if (api.name == name) return api
    }
    return extractorApis[0]
}

fun requireReferer(name: String): Boolean {
    return getExtractorApiFromName(name).requiresReferer
}

fun httpsify(url: String): String {
    return if (url.startsWith("//")) "https:$url" else url
}

suspend fun getPostForm(requestUrl: String, html: String): String? {
    val document = Ksoup.parse(html)
    val inputs = document.select("Form > input")
    if (inputs.size < 4) return null
    var op: String? = null
    var id: String? = null
    var mode: String? = null
    var hash: String? = null

    for (input in inputs) {
        val value = input.attr("value")
        when (input.attr("name")) {
            "op" -> op = value
            "id" -> id = value
            "mode" -> mode = value
            "hash" -> hash = value
            else -> Unit
        }
    }
    if (op == null || id == null || mode == null || hash == null) {
        return null
    }
    delay(5000) // ye this is needed, wont work with 0 delay

    return app.post(
        requestUrl,
        headers = mapOf(
            "content-type" to "application/x-www-form-urlencoded",
            "referer" to requestUrl,
            "user-agent" to USER_AGENT,
            "accept" to "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
        ),
        data = mapOf("op" to op, "id" to id, "mode" to mode, "hash" to hash)
    ).text
}

fun ExtractorApi.fixUrl(url: String): String {
    if (url.startsWith("http") ||
        // Do not fix JSON objects when passed as urls.
        url.startsWith("{\"")
    ) {
        return url
    }
    if (url.isEmpty()) {
        return ""
    }

    val startsWithNoHttp = url.startsWith("//")
    if (startsWithNoHttp) {
        return "https:$url"
    } else {
        if (url.startsWith('/')) {
            return mainUrl + url
        }
        return "$mainUrl/$url"
    }
}

abstract class ExtractorApi {
    abstract val name: String
    abstract val mainUrl: String
    abstract val requiresReferer: Boolean

    /** Determines which plugin a given provider is from. This is the full path to the plugin. */
    var sourcePlugin: String? = null

    //suspend fun getSafeUrl(url: String, referer: String? = null): List<ExtractorLink>? {
    //    return safeAsync { getUrl(url, referer) }
    //}

    // this is the new extractorapi, override to add subtitles and stuff
    @Throws
    open suspend fun getUrl(
        url: String,
        referer: String? = null,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        getUrl(url, referer)?.forEach(callback)
    }

    suspend fun getSafeUrl(
        url: String,
        referer: String? = null,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        try {
            getUrl(url, referer, subtitleCallback, callback)
        } catch (e: Exception) {
            logError(e)
        }
    }

    /**
     * Will throw errors, use getSafeUrl if you don't want to handle the exception yourself
     */
    @Throws
    open suspend fun getUrl(url: String, referer: String? = null): List<ExtractorLink>? {
        return emptyList()
    }

    open fun getExtractorUrl(id: String): String {
        return id
    }
}
