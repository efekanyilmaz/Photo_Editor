package com.efecjo.photoeditor.presentation.menu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.efecjo.photoeditor.BaseViewModel
import com.efecjo.photoeditor.presentation.menu.MenuEvent
import com.efecjo.photoeditor.presentation.menu.MenuState
import com.efecjo.photoeditor.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : BaseViewModel<MenuEvent>() {

    private val _menuState = mutableStateOf(MenuState())
    val menuState : State<MenuState> = _menuState

    private val _menuFlow = MutableSharedFlow<UiEvent>()
    val menuFlow = _menuFlow.asSharedFlow()


    override fun onEvent(event: MenuEvent) {
        when(event){
            MenuEvent.InitOperationsForMenuEvent -> {

            }
        }
    }


}