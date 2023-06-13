package com.efecjo.photoeditor.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberImagePainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.efecjo.photoeditor.R
import com.efecjo.photoeditor.presentation.components.GifImage
import com.efecjo.photoeditor.presentation.theme.DarkBlue
import com.efecjo.photoeditor.presentation.theme.SkyBlue
import com.efecjo.photoeditor.presentation.theme.SplashScreenImageHeight
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
                is SplashScreenFlow.Idle -> {
                    // Do nothing yet
                }
                is SplashScreenFlow.Initial -> {
                    // Do nothing yet
                }
                is SplashScreenFlow.RedirectedToEditor -> {
                    onNavigate("editor_screen")
                }
                is SplashScreenFlow.RedirectedToSettings -> {
                    // Do Nothing Yet
                }
                is SplashScreenFlow.RetryInitOps -> {
                    // Show error and retry atempt will shown
                }
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
    Surface(color = DarkBlue) {
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