package com.efecjo.photoeditor.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.efecjo.photoeditor.presentation.components.*
import com.efecjo.photoeditor.presentation.components.launchers.CameraLauncher
import com.efecjo.photoeditor.presentation.menu.HalfOpenDrawerMenu
import com.efecjo.photoeditor.presentation.theme.LightBlue
import com.efecjo.photoeditor.presentation.theme.PickFromGalleryButton
import com.efecjo.photoeditor.presentation.theme.TakePhotoFromGalleryButton
import com.efecjo.photoeditor.util.EnumLauncherType
import com.efecjo.photoeditor.util.GalleryLauncherFlow
import com.efecjo.photoeditor.util.GalleryLauncherFlowModel
import com.efecjo.photoeditor.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(
    onNavigate: (String) -> Unit,
    onPopBackStack: () -> Unit,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    LaunchedEffect(key1 = true) {
        viewModel.mainScreenFlow.collectLatest { flow ->
            when (flow) {
                is UiEvent.Navigate -> {
                    onNavigate(flow.route)
                }
                UiEvent.NavigateBack -> {
                    onPopBackStack()
                }
                is UiEvent.DrawerStateChanged -> {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
            }
        }
    }

    MainScreenContent(
        onPopBackStack = onPopBackStack,
        onNavigate = onNavigate,
        viewModel = viewModel,
        drawerState = drawerState
    )
}

@Composable
fun MainScreenContent(
    onPopBackStack: () -> Unit,
    onNavigate: (String) -> Unit,
    viewModel: MainScreenViewModel,
    drawerState: DrawerState
) {
    val galleryLauncherFlow =
        GalleryLauncherFlow.galleryFlow.collectAsState(initial = GalleryLauncherFlowModel(uri = ""))
    val mainScreenState = viewModel.mainState.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
    ) {
        HalfOpenDrawerMenu(
            onNavigate = onNavigate,
            onPopBackStack = onPopBackStack,
            drawerState = drawerState
        )
        MenuItemIconButton(onClick = {
            viewModel.onEvent(MainScreenEvent.MenuClicked)
        })
        //HorizontalImageSlider(items = viewModel.mainState.value.imageList)

        MainScreenButton(
            onClick = {
                viewModel.onEvent(MainScreenEvent.SelectPhotoFromGallery)
            },
            modifier = Modifier.align(Alignment.CenterStart),
            colorPalette = PickFromGalleryButton,
            text = "Select Photo From Gallery"
        )
        MainScreenButton(
            onClick = {
                viewModel.onEvent(MainScreenEvent.TakePhotoFromCamera)
            },
            modifier = Modifier.align(Alignment.CenterEnd),
            colorPalette = TakePhotoFromGalleryButton,
            text = "Take Photo From Camera"
        )

        when (mainScreenState.launcherType) {

            EnumLauncherType.CAMERA -> {
                CameraLauncher(mainScreenState.permissionList)
            }
            EnumLauncherType.GALLERY -> {
                GalleryLauncher(mainScreenState.permissionList)
            }
            EnumLauncherType.NONE -> {
            }
        }

        if (galleryLauncherFlow.value.uri.isNotEmpty()) {
            viewModel.onEvent(MainScreenEvent.ImageSelected)
        }
    }
}