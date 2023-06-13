package com.efecjo.photoeditor.presentation.components.bottomnav

import androidx.compose.ui.graphics.vector.ImageVector
import com.efecjo.photoeditor.util.Screen

data class BottomNavItem(
    val route: String,
    val childRoutes: List<Screen>?,
    val icon: ImageVector? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)
