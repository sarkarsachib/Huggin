package com.huggin.app.actions.temp

import android.app.Activity
import android.content.Context
import com.huggin.app.R
import com.huggin.app.actions.VideoClickAction
import com.huggin.app.ui.player.ExtractorUri
import com.huggin.app.ui.player.GeneratorPlayer
import com.huggin.app.ui.player.LOADTYPE_INAPP
import com.huggin.app.ui.player.SubtitleData
import com.huggin.app.ui.player.VideoGenerator
import com.huggin.app.ui.result.LinkLoadingResult
import com.huggin.app.ui.result.ResultEpisode
import com.huggin.app.utils.ExtractorLink
import com.huggin.app.utils.ExtractorLinkType
import com.huggin.app.utils.UIHelper.navigate
import com.huggin.app.utils.txt

class PlayMirrorAction : VideoClickAction() {
    override val name = txt(R.string.episode_action_play_mirror)

    override val oneSource = true

    override val isPlayer = true

    override val sourceTypes: Set<ExtractorLinkType> = LOADTYPE_INAPP

    override fun shouldShow(context: Context?, video: ResultEpisode?) = true

    override suspend fun runAction(
        context: Context?,
        video: ResultEpisode,
        result: LinkLoadingResult,
        index: Int?
    ) {
        //Implemented a generator to handle the single
        val activity = context as? Activity ?: return
        val link = index?.let { result.links[it] }
        val generatorMirror = object : VideoGenerator<ResultEpisode>(listOf(video)) {
            override val hasCache: Boolean = false
            override val canSkipLoading: Boolean = false
            override fun getId(index: Int): Int = video.id

            override suspend fun generateLinks(
                clearCache: Boolean,
                sourceTypes: Set<ExtractorLinkType>,
                callback: (Pair<ExtractorLink?, ExtractorUri?>) -> Unit,
                subtitleCallback: (SubtitleData) -> Unit,
                offset: Int,
                isCasting: Boolean
            ): Boolean {
                index?.let { callback(link to null) }
                result.subs.forEach { subtitle -> subtitleCallback(subtitle) }
                return true
            }
        }

        activity.navigate(
            R.id.global_to_navigation_player,
            GeneratorPlayer.newInstance(
                generatorMirror, 0, result.syncData
            )
        )
    }
}