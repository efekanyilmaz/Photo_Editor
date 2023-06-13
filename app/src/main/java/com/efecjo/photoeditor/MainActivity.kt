package com.efecjo.photoeditor

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.isStatusBarVisible = false
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

        StandardScaffold(
            navController = navController,
            showBottomBar = navBackStackEntry?.shouldShowBottomBar() ?: false,
            modifier = Modifier.fillMaxSize(),
            onFabClick = {
            },
            bottomNavItems = mainScreenItems
        ) {
            Navigation(navController)

        }
    }
}