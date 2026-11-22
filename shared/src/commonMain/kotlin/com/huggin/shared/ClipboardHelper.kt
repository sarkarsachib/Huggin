package com.huggin.shared

import androidx.compose.ui.platform.Clipboard

expect suspend fun Clipboard.setPlainText(label: String, text: String)
expect suspend fun Clipboard.getPlainText(): String?
