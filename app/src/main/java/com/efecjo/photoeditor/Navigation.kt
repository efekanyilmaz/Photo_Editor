package com.efecjo.photoeditor

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.efecjo.photoeditor.presentation.menu.HalfOpenDrawerMenu
import com.efecjo.photoeditor.presentation.editor.EditorScreen
import com.efecjo.photoeditor.presentation.main.MainScreen
import com.efecjo.photoeditor.presentation.splash.SplashScreen
import com.efecjo.photoeditor.util.Screen
import kotlin.system.exitProcess

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
        SplashScreen(
            onPopBackStack = navController::popBackStack,
            onNavigate = navController::navigate,
        )
    }
        composable(Screen.EditorScreen.route) {
            EditorScreen(
                onNavigate = navController::navigate,
                onPopBackStack = navController::popBackStack,
            )
        }
        composable(Screen.MainScreen.route) {
            MainScreen(
                onNavigate = navController::navigate,
                onPopBackStack = navController::popBackStack
            )
        }
    }

    BackHandler(onBack = {
        val navBackStackEntry = navController.currentBackStackEntry
        val canPop = navBackStackEntry != null && navController.previousBackStackEntry != null

        if (canPop) {
            navController.popBackStack()
        } else {
            exitProcess(0) // Close the app if the back stack is empty
        }
    })
}
