package com.efecjo.photoeditor.util

sealed class UiEvent : Event() {
    data class Navigate(val route: String) : UiEvent()
    object NavigateBack : UiEvent()
    object DrawerStateChanged: UiEvent()
}