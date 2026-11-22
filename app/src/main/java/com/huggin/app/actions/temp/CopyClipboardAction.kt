package com.huggin.app.actions.temp

import android.content.Context
import com.huggin.app.actions.VideoClickAction
import com.huggin.app.ui.result.LinkLoadingResult
import com.huggin.app.ui.result.ResultEpisode
import com.huggin.app.utils.txt
import com.huggin.app.utils.UIHelper.clipboardHelper

class CopyClipboardAction: VideoClickAction() {
    override val name = txt("Copy to clipboard")

    override val oneSource = true

    override fun shouldShow(context: Context?, video: ResultEpisode?) = true

    override suspend fun runAction(
        context: Context?,
        video: ResultEpisode,
        result: LinkLoadingResult,
        index: Int?
    ) {
        if (index == null) return
        val link = result.links.getOrNull(index) ?: return
        clipboardHelper(txt(link.name), link.url)
    }
}