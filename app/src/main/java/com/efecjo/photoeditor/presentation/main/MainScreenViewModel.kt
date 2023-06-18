package com.efecjo.photoeditor.presentation.main

import android.Manifest
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.efecjo.photoeditor.BaseViewModel
import com.efecjo.photoeditor.domain.use_case.main.GetLastEditedPhotosUseCase
import com.efecjo.photoeditor.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getLastEditedPhotosUseCase: GetLastEditedPhotosUseCase,
) : BaseViewModel<MainScreenEvent>() {

    private val _mainScreenFlow = MutableSharedFlow<UiEvent>()
    val mainScreenFlow = _mainScreenFlow.asSharedFlow()

    private val _mainState = mutableStateOf(MainScreenState())
    val mainState: State<MainScreenState> = _mainState

    override fun onEvent(event: MainScreenEvent) {
        when (event) {
            MainScreenEvent.InitMainScreen -> {
                viewModelScope.launch {
                    when (val getLastEdited = getLastEditedPhotosUseCase()) {
                        is Resource.Error -> {
                            _mainState.value = _mainState.value.copy(
                                imageList = getLastEdited.data ?: emptyList()
                            )
                        }
                        is Resource.Success -> {
                            _mainState.value = _mainState.value.copy(
                                imageList = getLastEdited.data ?: emptyList()
                            )
                        }
                    }
                }
            }
            MainScreenEvent.MenuClicked -> {
                viewModelScope.launch {
                    _mainScreenFlow.emit(UiEvent.DrawerStateChanged)
                }
            }
            is MainScreenEvent.SelectPhotoFromGallery -> {
                viewModelScope.launch {
                    _mainState.value = _mainState.value.copy(
                        launcherType = EnumLauncherType.GALLERY,
                        permissionList = listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    )
                }
            }
            is MainScreenEvent.TakePhotoFromCamera -> {
                viewModelScope.launch {
                    _mainState.value = _mainState.value.copy(
                        launcherType = EnumLauncherType.CAMERA,
                        permissionList = listOf(Manifest.permission.CAMERA)
                    )
                }
            }
            MainScreenEvent.ImageSelected -> {
                viewModelScope.launch {
                    _mainState.value = _mainState.value.copy(
                        launcherType = EnumLauncherType.NONE
                    )
                    //GalleryLauncherFlow.setGalleryState(GalleryLauncherFlowModel(uri = ""))
                    _mainScreenFlow.emit(UiEvent.Navigate(Screen.EditorScreen.route))
                }
            }
        }
    }
}
