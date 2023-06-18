package com.efecjo.photoeditor.presentation.theme

import androidx.compose.ui.graphics.Color

val LightBlue = Color(0xFF89CFF0)
val SkyBlue = Color(0xFF74BCFD)
val DarkBlue = Color(0xFF2C3E50)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val GreenSplash = Color(0xFF8BF9B7)

val PickFromGalleryButton = ColorPalette(
    primary = LightBlue,
    onPrimary = White,
    surface = SkyBlue,
    onSurface = DarkBlue
)

val TakePhotoFromGalleryButton = ColorPalette(
    primary = DarkBlue,
    onPrimary = GreenSplash,
    surface = SkyBlue,
    onSurface = White
)
data class ColorPalette(
    val primary: Color? = null,
    val background: Color? = null,
    val onBackground: Color? = null,
    val onPrimary: Color? = null,
    val surface: Color? = null,
    val onSurface: Color? = null,
)