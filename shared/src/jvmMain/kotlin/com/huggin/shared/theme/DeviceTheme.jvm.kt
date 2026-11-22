package com.huggin.shared.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

internal actual object DeviceTheme {
    @Composable
    @ReadOnlyComposable
    actual fun resolveDynamicTheme(): HugginColorScheme = darkScheme()

    @Composable
    @ReadOnlyComposable
    actual fun resolveDynamicPrimaryColor(): Color = HugginPrimaryColor.NORMAL.color

    @Composable
    @ReadOnlyComposable
    actual fun resolveDynamicSecondaryColor(): Color = HugginPrimaryColor.NORMAL.color
}