package com.efecjo.photoeditor.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

val LightColorPalette = lightColors(
    primary = LightBlue,
    background = White,
    onBackground = DarkBlue,
    onPrimary = White,
    surface = SkyBlue,
    onSurface = DarkBlue
)

@Composable
fun PhotoEditorTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}