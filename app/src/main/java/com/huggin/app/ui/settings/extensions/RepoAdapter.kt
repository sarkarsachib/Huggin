package com.huggin.app.ui.settings.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import com.huggin.app.R
import com.huggin.app.databinding.RepositoryItemBinding
import com.huggin.app.databinding.RepositoryItemTvBinding
import com.huggin.app.plugins.RepositoryManager.PREBUILT_REPOSITORIES
import com.huggin.app.ui.BaseDiffCallback
import com.huggin.app.ui.NoStateAdapter
import com.huggin.app.ui.ViewHolderState
import com.huggin.app.ui.settings.Globals.TV
import com.huggin.app.ui.settings.Globals.isLayout
import com.huggin.app.utils.ImageLoader.loadImage
import com.huggin.app.utils.UIHelper.clipboardHelper
import com.huggin.app.utils.getImageFromDrawable
import com.huggin.app.utils.txt

class RepoAdapter(
    val isSetup: Boolean,
    val clickCallback: RepoAdapter.(RepositoryData) -> Unit,
    val imageClickCallback: RepoAdapter.(RepositoryData) -> Unit,
    /** In setup mode the trash icons will be replaced with download icons */
) :
    NoStateAdapter<RepositoryData>(diffCallback = BaseDiffCallback(itemSame = { a, b ->
        a.url == b.url
    })) {

    override fun onCreateContent(parent: ViewGroup): ViewHolderState<Any> {
        val layout = if (isLayout(TV)) RepositoryItemTvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ) else RepositoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderState(layout)
    }

    override fun onClearView(holder: ViewHolderState<Any>) {
        when (val binding = holder.view) {
            is RepositoryItemBinding -> clearImage(binding.entryIcon)
            is RepositoryItemTvBinding -> clearImage(binding.entryIcon)
        }
    }

    override fun onBindContent(holder: ViewHolderState<Any>, item: RepositoryData, position: Int) {
        val isPrebuilt = PREBUILT_REPOSITORIES.contains(item)
        val drawable =
            if (isSetup) R.drawable.netflix_download else R.drawable.ic_baseline_delete_outline_24
        when (val binding = holder.view) {
            is RepositoryItemTvBinding -> {
                binding.apply {
                    // Only shows icon if on setup or if it isn't a prebuilt repo.
                    // No delete buttons on prebuilt repos.
                    if (!isPrebuilt || isSetup) {
                        actionButton.setImageResource(drawable)
                    }

                    // Prebuilt repos are non-interactive - users cannot access them
                    val isPrebuiltClickable = !isPrebuilt || isSetup
                    actionButton.setOnClickListener {
                        if (isPrebuiltClickable) imageClickCallback(item)
                    }

                    repositoryItemRoot.setOnClickListener {
                        if (isPrebuiltClickable) clickCallback(item)
                    }

                    mainText.text = item.name
                    subText.text = item.url
                    if (!item.iconUrl.isNullOrEmpty()) {
                        entryIcon.loadImage(item.iconUrl) {
                            error(
                                getImageFromDrawable(
                                    binding.root.context,
                                    R.drawable.ic_github_logo
                                )
                            )
                        }
                    } else {
                        entryIcon.loadImage(R.drawable.ic_github_logo)
                    }
                }
            }

            is RepositoryItemBinding -> {
                binding.apply {
                    // Only shows icon if on setup or if it isn't a prebuilt repo.
                    // No delete buttons on prebuilt repos.
                    if (!isPrebuilt || isSetup) {
                        actionButton.setImageResource(drawable)
                    }

                    // Prebuilt repos are non-interactive - users cannot access them
                    val isPrebuiltClickable = !isPrebuilt || isSetup
                    actionButton.setOnClickListener {
                        if (isPrebuiltClickable) imageClickCallback(item)
                    }

                    repositoryItemRoot.setOnClickListener {
                        if (isPrebuiltClickable) clickCallback(item)
                    }
                    repositoryItemRoot.setOnLongClickListener {
                        val shareableRepoData =
                            "${item.name}$SHAREABLE_REPO_SEPARATOR\n ${item.url}"
                        clipboardHelper(txt(R.string.repo_copy_label), shareableRepoData)
                        true
                    }

                    mainText.text = item.name
                    subText.text = item.url
                    if (!item.iconUrl.isNullOrEmpty()) {
                        entryIcon.loadImage(item.iconUrl) {
                            error(
                                getImageFromDrawable(
                                    binding.root.context,
                                    R.drawable.ic_github_logo
                                )
                            )
                        }
                    } else {
                        entryIcon.loadImage(R.drawable.ic_github_logo)
                    }
                }
            }
        }
    }

    companion object {
        const val SHAREABLE_REPO_SEPARATOR = " : "
    }
}