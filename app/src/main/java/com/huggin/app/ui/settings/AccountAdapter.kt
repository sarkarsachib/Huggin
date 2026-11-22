package com.huggin.app.ui.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.huggin.app.R
import com.huggin.app.databinding.AccountSingleBinding
import com.huggin.app.syncproviders.AuthData
import com.huggin.app.ui.BaseDiffCallback
import com.huggin.app.ui.NoStateAdapter
import com.huggin.app.ui.ViewHolderState
import com.huggin.app.utils.ImageLoader.loadImage

class AccountClickCallback(val action: Int, val view: View, val card: AuthData)

class AccountAdapter(
    private val clickCallback: (AccountClickCallback) -> Unit
) :
    NoStateAdapter<AuthData>(
        diffCallback = BaseDiffCallback(itemSame = { a, b ->
            a.user.id == b.user.id
        })
    ) {

    override fun onCreateContent(parent: ViewGroup): ViewHolderState<Any> {
        return ViewHolderState(
            AccountSingleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onClearView(holder: ViewHolderState<Any>) {
        val binding = holder.view as? AccountSingleBinding ?: return
        clearImage(binding.accountProfilePicture)
    }

    override fun onBindContent(holder: ViewHolderState<Any>, item: AuthData, position: Int) {
        val binding = holder.view as? AccountSingleBinding ?: return
        binding.apply {
            accountName.text = item.user.name
                ?: "${binding.accountName.context.getString(R.string.account)} ${position + 1}"
            accountProfilePicture.isVisible = true
            accountProfilePicture.loadImage(
                item.user.profilePicture,
                headers = item.user.profilePictureHeaders
            )

            root.setOnClickListener {
                clickCallback.invoke(AccountClickCallback(0, root, item))
            }
        }
    }
}
