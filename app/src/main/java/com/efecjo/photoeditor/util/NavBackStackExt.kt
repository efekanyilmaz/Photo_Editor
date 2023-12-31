package com.efecjo.photoeditor.util

import androidx.navigation.NavBackStackEntry

fun NavBackStackEntry.shouldShowBottomBar(): Boolean {
    return this.destination.route in listOf(
        Screen.EditorScreen.route,
    )
}