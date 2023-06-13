package com.efecjo.photoeditor.util

sealed class Screen(val route : String){
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object EditorScreen : Screen("editor_screen")
}
