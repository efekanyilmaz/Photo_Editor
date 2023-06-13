package com.efecjo.photoeditor.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun SplashScreen(
    onPopBackStack: () -> Unit,
    onNavigate: (String) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val gif = remember { mutableStateOf(R.drawable.cam_dribbble) }
    Surface {
        SplashScreenContent(
            onPopBackStack = onPopBackStack,
            onNavigate = onNavigate,
            viewModel = viewModel,
            gif = gif
        )
    }
    viewModel.onEvent(SplashEvent.StartInitProcess)
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