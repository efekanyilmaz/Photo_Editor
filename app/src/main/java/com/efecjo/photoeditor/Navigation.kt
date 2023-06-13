package com.efecjo.photoeditor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.efecjo.photoeditor.presentation.editor.EditorScreen
import com.efecjo.photoeditor.presentation.main.MainScreen
import com.efecjo.photoeditor.presentation.splash.SplashScreen
import com.efecjo.photoeditor.util.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
) {
    NavHost(navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
        SplashScreen(
            scaffoldState = scaffoldState,
            onPopBackStack = navController::popBackStack,
            onNavigate = navController::navigate,
        )
    }
        composable(Screen.MainScreen.route) {
            MainScreen(
                onNavigate = navController::navigate,
                onPopBackStack = navController::popBackStack,
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.EditorScreen.route) {
            EditorScreen(
                onNavigate = navController::navigate,
                onPopBackStack = navController::popBackStack,
                scaffoldState = scaffoldState
            )
        }
    }
}
