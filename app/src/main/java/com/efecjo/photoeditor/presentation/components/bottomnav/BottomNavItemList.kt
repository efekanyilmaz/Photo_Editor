package com.efecjo.photoeditor.presentation.components.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import com.efecjo.photoeditor.util.Screen

object BottomNavItemList {
    val mainScreenItems = listOf<BottomNavItem>(
        BottomNavItem(
            route = Screen.MainScreen.route,
            childRoutes = mutableListOf(
                Screen.EditorScreen
            ),
            icon = Icons.Outlined.Home,
            contentDescription = "Add Photo"
        ),
    )
}