package com.efecjo.photoeditor.presentation.main

sealed class MainScreenEvent {
    object InitMainScreen : MainScreenEvent()
    object MenuClicked : MainScreenEvent()
    object SelectPhotoFromGallery : MainScreenEvent()
    object TakePhotoFromCamera : MainScreenEvent()
    object ImageSelected : MainScreenEvent()
}