package com.efecjo.photoeditor.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.efecjo.photoeditor.presentation.components.bottomnav.BottomNavItem
import com.efecjo.photoeditor.presentation.components.bottomnav.StandardBottomNavItem
import com.efecjo.photoeditor.presentation.theme.BottomBarElevation
import com.efecjo.photoeditor.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    showTopBar: Boolean = false,
    bottomNavItems: List<BottomNavItem>,
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {

    Scaffold(
        scaffoldState = rememberScaffoldState(),
        modifier = modifier,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.edit_button)
                    )
                }
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = CircleShape,
                    elevation = BottomBarElevation
                ) {
                    BottomNavigation(
                        modifier = Modifier
                            .fillMaxWidth()
                            .navigationBarsPadding()
                    ) {
                        bottomNavItems.forEachIndexed { _, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = isBottomNavItemSelected(bottomNavItem, navController),
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (isRelatedScreen(bottomNavItem, navController)) {
                                    navController.popBackStack(bottomNavItem.route, false)
                                } else if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                } else {
                                    navController.popBackStack(bottomNavItem.route, false)
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {
        content()
    }
}

fun isBottomNavItemSelected(
    bottomNavItem: BottomNavItem,
    navController: NavController
): Boolean {

    if (navController.currentDestination?.route?.startsWith(
            bottomNavItem.route
        ) == true
    ) return true

    return isRelatedScreen(bottomNavItem, navController)
}

fun isRelatedScreen(
    bottomNavItem: BottomNavItem,
    navController: NavController
): Boolean {
    val childRouteListForCurrentScreen = bottomNavItem.childRoutes
    if (childRouteListForCurrentScreen != null) {
        for (child in childRouteListForCurrentScreen) {
            if (navController.currentDestination?.route?.startsWith(
                    child.route
                ) == true
            ) {
                return true
            }
        }
    }
    return false
}
