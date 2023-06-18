package com.efecjo.photoeditor

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.efecjo.photoeditor.presentation.components.StandardScaffold
import com.efecjo.photoeditor.presentation.components.bottomnav.BottomNavItemList.mainScreenItems
import com.efecjo.photoeditor.presentation.theme.PhotoEditorTheme
import com.efecjo.photoeditor.util.shouldShowBottomBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            PhotoEditorTheme {
                PhotoEditorApp()
            }
        }

    }
}

@Composable
fun PhotoEditorApp() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val systemUiController = rememberSystemUiController()
        val statusBarHeight = WindowInsets.systemBars.asPaddingValues()

        SideEffect {
            systemUiController.setSystemBarsColor(
                Color.Transparent,
                darkIcons = false,
                isNavigationBarContrastEnforced = true)
        }
        StandardScaffold(
            navController = navController,
            showBottomBar = navBackStackEntry?.shouldShowBottomBar() ?: false,
            modifier = Modifier.fillMaxSize().padding(paddingValues = statusBarHeight).background(Color.Transparent),
            onFabClick = {
            },
            bottomNavItems = mainScreenItems
        ) {
            Navigation(navController)

        }
    }
}