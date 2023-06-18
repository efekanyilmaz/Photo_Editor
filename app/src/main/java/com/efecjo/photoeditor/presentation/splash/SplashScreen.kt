package com.efecjo.photoeditor.presentation.splash

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.efecjo.photoeditor.R
import com.efecjo.photoeditor.presentation.components.GifImage
import com.efecjo.photoeditor.presentation.theme.DarkBlue
import com.efecjo.photoeditor.presentation.theme.GreenSplash
import com.efecjo.photoeditor.util.Screen
import com.efecjo.photoeditor.util.UiEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreen(
    onPopBackStack: () -> Unit,
    onNavigate: (String) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val gif = remember { mutableStateOf(R.drawable.cam_dribbble) }
    val triggerInitProcess = remember {
        {
            viewModel.onEvent(SplashEvent.StartInitProcess)
        }
    }

    /** Trigger init Process after 1500ms **/
    LaunchedEffect(key1 = true ){
        delay(1500)
        triggerInitProcess()
    }

    /** Flow Collector **/
    LaunchedEffect(key1 = true) {
        viewModel.splashFlow.collectLatest { flow ->
            when (flow) {
                is UiEvent.Navigate -> {
                    onNavigate(flow.route)
                }
                UiEvent.NavigateBack -> {
                    onPopBackStack()
                }
                else -> {}
            }
        }
    }

    /** View **/
    Surface {
        SplashScreenContent(
            onPopBackStack = onPopBackStack,
            onNavigate = onNavigate,
            viewModel = viewModel,
            gif = gif
        )
    }

}

@Composable
fun SplashScreenContent(
    onPopBackStack: () -> Unit,
    onNavigate: (String) -> Unit,
    viewModel: SplashViewModel,
    gif: MutableState<Int>
) {
    Surface(color = GreenSplash, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GifImage()
        }
    }
}