package com.efecjo.photoeditor.presentation.splash

import androidx.lifecycle.viewModelScope
import com.efecjo.photoeditor.BaseViewModel
import com.efecjo.photoeditor.domain.use_case.splash.InitOperationsUseCase
import com.efecjo.photoeditor.util.Resource
import com.efecjo.photoeditor.util.Screen
import com.efecjo.photoeditor.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val initialOperationUseCase: InitOperationsUseCase
) : BaseViewModel<SplashEvent>() {

    private val _splashFlow = MutableSharedFlow<UiEvent>()
    val splashFlow = _splashFlow.asSharedFlow()
    override fun onEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.StartInitProcess -> {
                viewModelScope.launch {
                    when (val initOps = initialOperationUseCase()) {
                        is Resource.Success -> {
                            if (initOps.data == true) {
                                _splashFlow.emit(UiEvent.Navigate(Screen.MainScreen.route))
                            } else {
                                onEvent(SplashEvent.StartInitProcess)
                            }
                        }
                        is Resource.Error -> {
                            onEvent(SplashEvent.StartInitProcess)
                        }

                    }
                }
            }
        }
    }


}