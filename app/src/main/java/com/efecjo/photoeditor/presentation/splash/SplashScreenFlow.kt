package com.efecjo.photoeditor.presentation.splash

sealed class SplashScreenFlow {

    object Initial : SplashScreenFlow()
    object RedirectedToSettings : SplashScreenFlow() // For permissions
    object RedirectedToEditor : SplashScreenFlow()
    object Idle : SplashScreenFlow()
    object RetryInitOps : SplashScreenFlow()
}