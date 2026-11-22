package com.huggin.shared.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

internal expect object DeviceTheme {
    @Composable
    @ReadOnlyComposable
    fun resolveDynamicTheme(): HugginColorScheme
    @Composable
    @ReadOnlyComposable
    fun resolveDynamicPrimaryColor(): Color
    @Composable
    @ReadOnlyComposable
    fun resolveDynamicSecondaryColor(): Color
}