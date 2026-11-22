package com.mihon.presentation.settings.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.huggin.shared.generated.resources.Res
import com.huggin.shared.generated.resources.info
import com.huggin.shared.generated.resources.lorem_content
import com.huggin.shared.generated.resources.lorem_title
import com.huggin.shared.theme.HugginPreviewTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import com.mihon.presentation.secondaryItemAlpha
import com.mihon.material.padding

@Composable
internal fun InfoWidget(text: String) {
    Column(
        modifier = Modifier
            .padding(
                horizontal = PrefsHorizontalPadding,
                vertical = MaterialTheme.padding.medium,
            )
            .secondaryItemAlpha(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.padding.medium),
    ) {
        Icon(
            painter = painterResource(Res.drawable.info),
            contentDescription = null,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@PreviewLightDark
@Composable
private fun InfoWidgetPreview() {
    HugginPreviewTheme {
        Surface {
            InfoWidget(text = stringResource(Res.string.lorem_content))
        }
    }
}
