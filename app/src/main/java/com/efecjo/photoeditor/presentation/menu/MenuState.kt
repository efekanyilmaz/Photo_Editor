package com.efecjo.photoeditor.presentation.menu

import androidx.compose.ui.graphics.ImageBitmap

data class MenuState(
    val isMenuInit : Boolean = true,
    val profilePhoto : ImageBitmap? = null,
    val isDrawerClosed : Boolean = false
)
