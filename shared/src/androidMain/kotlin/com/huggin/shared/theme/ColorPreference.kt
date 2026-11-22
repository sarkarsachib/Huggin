package com.huggin.shared.theme

import android.content.Context
import android.os.Build
import androidx.preference.PreferenceManager

/** TODO: This should be replaced with a better system */

fun perfToMode(perf: String?) =
    when (perf) {
        "System" -> HugginThemeMode.FollowSystem
        "Black" -> HugginThemeMode.Dark
        "Light" -> HugginThemeMode.Light
        "Amoled" -> HugginThemeMode.Amoled
        "AmoledLight" -> HugginThemeMode.AmoledLight
        "Dracula" -> HugginThemeMode.Dracula
        "Lavender" -> HugginThemeMode.Lavender
        "SilentBlue" -> HugginThemeMode.SilentBlue
        "Monet" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            HugginThemeMode.Dynamic
        } else {
            HugginThemeMode.Dark
        }

        else -> HugginThemeMode.Dark
    }

fun perfToColor(perf : String?) = when (perf) {
    "Normal" -> HugginPrimaryColor.NORMAL
    "Blue" -> HugginPrimaryColor.BLUE
    "Purple" -> HugginPrimaryColor.PURPLE
    "Green" -> HugginPrimaryColor.GREEN
    "GreenApple" -> HugginPrimaryColor.GREEN_APPLE
    "Red" -> HugginPrimaryColor.RED
    "Banana" -> HugginPrimaryColor.BANANA
    "Party" -> HugginPrimaryColor.PARTY
    "Pink" -> HugginPrimaryColor.PINK
    "CarnationPink" -> HugginPrimaryColor.CARNATION_PINK
    "Maroon" -> HugginPrimaryColor.MAROON
    "DarkGreen" -> HugginPrimaryColor.DARK_GREEN
    "NavyBlue" -> HugginPrimaryColor.NAVY_BLUE
    "Grey" -> HugginPrimaryColor.GREY
    "White" -> HugginPrimaryColor.WHITE
    "Brown" -> HugginPrimaryColor.BROWN
    "Orange" -> HugginPrimaryColor.ORANGE
    "DandelionYellow" -> HugginPrimaryColor.DANDELION_YELLOW
    "CoolBlue" -> HugginPrimaryColor.COOL_BLUE
    "Lavender" -> HugginPrimaryColor.LAVENDER
    "Monet" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        HugginPrimaryColor.DYNAMIC
    } else {
        HugginPrimaryColor.NORMAL
    }

    "Monet2" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        HugginPrimaryColor.DYNAMIC_TWO
    } else {
        HugginPrimaryColor.NORMAL
    }

    else -> HugginPrimaryColor.NORMAL
}

fun Context.loadThemeMode(): HugginThemeMode {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    return perfToMode(prefs.getString("theme_key", "AmoledLight"))
}

fun Context.loadPrimaryColor(): HugginPrimaryColor {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    return perfToColor(prefs.getString("primary_color_key", "Normal"))
}