package com.huggin.shared.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

/**
 * Maps to the XML custom attrs declared in attrs.xml:
 * TODO: Remove this comment when we migrate fully
 *  and attrs.xml will no longer be used at all.
 *
 * | XML ?attr                | Here               |
 * |--------------------------|--------------------|
 * | primaryBlackBackground   | [background]       |
 * | primaryGrayBackground    | [surfaceVariant]   |
 * | iconGrayBackground       | [surface]          |
 * | boxItemBackground        | [surfaceContainer] |
 * | textColor                | [onBackground]     |
 * | grayTextColor            | [onSurfaceVariant] |
 * | iconColor                | [icon]             |
 * | colorPrimary             | [primary]          |
 * | colorOngoing             | [ongoing]          |
 *
 * All fields are [MutableState] so Compose recomposes automatically
 * if the scheme is swapped at runtime (e.g. user changes theme without restart).
 */
@Stable
class HugginColorScheme(
    background: Color,
    surfaceVariant: Color,
    surface: Color,
    surfaceContainer: Color,
    onBackground: Color,
    onSurfaceVariant: Color,
    icon: Color,
    primary: Color,
    ongoing: Color,
    isLight: Boolean,
) {
    /** primaryBlackBackground */
    var background by mutableStateOf(background)

    /** primaryGrayBackground */
    var surfaceVariant by mutableStateOf(surfaceVariant)

    /** iconGrayBackground */
    var surface by mutableStateOf(surface)

    /** boxItemBackground */
    var surfaceContainer by mutableStateOf(surfaceContainer)

    /** textColor */
    var onBackground by mutableStateOf(onBackground)

    /** grayTextColor */
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant)

    /** iconColor */
    var icon by mutableStateOf(icon)

    /** colorPrimary */
    var primary by mutableStateOf(primary)

    /** colorOngoing */
    var ongoing by mutableStateOf(ongoing)
    var isLight by mutableStateOf(isLight)

    fun copy(
        background: Color = this.background,
        surfaceVariant: Color = this.surfaceVariant,
        surface: Color = this.surface,
        surfaceContainer: Color = this.surfaceContainer,
        onBackground: Color = this.onBackground,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        icon: Color = this.icon,
        primary: Color = this.primary,
        ongoing: Color = this.ongoing,
        isLight: Boolean = this.isLight,
    ) = HugginColorScheme(
        background, surfaceVariant, surface, surfaceContainer,
        onBackground, onSurfaceVariant, icon, primary, ongoing, isLight,
    )
}

internal fun darkScheme() = HugginColorScheme(
    background = HugginPalette.DarkBlackBg,
    surfaceVariant = HugginPalette.DarkPrimaryGrayBg,
    surface = HugginPalette.DarkIconGrayBg,
    surfaceContainer = HugginPalette.DarkBoxItemBg,
    onBackground = HugginPalette.DarkText,
    onSurfaceVariant = HugginPalette.DarkGrayText,
    icon = HugginPalette.DarkIcon,
    primary = HugginPalette.Primary,
    ongoing = HugginPalette.Ongoing,
    isLight = false,
)


internal fun amoledScheme() = darkScheme().copy(
    background = HugginPalette.AmoledBlack,
    surface = HugginPalette.AmoledBlack,
    surfaceVariant = HugginPalette.AmoledBlack,
    surfaceContainer = HugginPalette.AmoledBlack,
)

internal fun amoledLightScheme() = amoledScheme().copy(
    surfaceVariant = HugginPalette.AmoledNearBlack,
)

internal fun lightScheme() = HugginColorScheme(
    background = HugginPalette.LightBlackBg,
    surfaceVariant = HugginPalette.LightPrimaryGrayBg,
    surface = HugginPalette.LightIconGrayBg,
    surfaceContainer = HugginPalette.LightBoxItemBg,
    onBackground = HugginPalette.LightText,
    onSurfaceVariant = HugginPalette.LightGrayText,
    icon = HugginPalette.LightIcon,
    primary = HugginPalette.Primary,
    ongoing = HugginPalette.Ongoing,
    isLight = true,
)

internal fun draculaScheme() = HugginColorScheme(
    background = HugginPalette.DraculaBlackBg,
    surfaceVariant = HugginPalette.DraculaPrimaryGrayBg,
    surface = HugginPalette.DraculaIconGrayBg,
    surfaceContainer = HugginPalette.DraculaBoxItemBg,
    onBackground = HugginPalette.DraculaText,
    onSurfaceVariant = HugginPalette.DraculaGrayText,
    icon = HugginPalette.DraculaIcon,
    primary = HugginPalette.Primary,
    ongoing = HugginPalette.Ongoing,
    isLight = false,
)

internal fun lavenderScheme() = HugginColorScheme(
    background = HugginPalette.LavenderBlackBg,
    surfaceVariant = HugginPalette.LavenderPrimaryGrayBg,
    surface = HugginPalette.LavenderIconGrayBg,
    surfaceContainer = HugginPalette.LavenderBoxItemBg,
    onBackground = HugginPalette.LavenderText,
    onSurfaceVariant = HugginPalette.LavenderGrayText,
    icon = HugginPalette.LavenderIcon,
    primary = HugginPalette.Primary,
    ongoing = HugginPalette.Ongoing,
    isLight = true,
)

internal fun silentBlueScheme() = HugginColorScheme(
    background = HugginPalette.SilentBlueBlackBg,
    surfaceVariant = HugginPalette.SilentBluePrimaryGrayBg,
    surface = HugginPalette.SilentBlueIconGrayBg,
    surfaceContainer = HugginPalette.SilentBlueBoxItemBg,
    onBackground = HugginPalette.SilentBlueText,
    onSurfaceVariant = HugginPalette.SilentBlueGrayText,
    icon = HugginPalette.SilentBlueIcon,
    primary = HugginPalette.Primary,
    ongoing = HugginPalette.Ongoing,
    isLight = false,
)