package com.efecjo.photoeditor.presentation.splash

import androidx.lifecycle.viewModelScope
import com.efecjo.photoeditor.BaseViewModel
import com.efecjo.photoeditor.domain.use_case.splash.InitOperationsUseCase
import com.efecjo.photoeditor.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val initialOperationUseCase: InitOperationsUseCase
) : BaseViewModel<SplashEvent>() {

    private val _splashFlow = MutableSharedFlow<SplashScreenFlow>()
    val splashFlow = _splashFlow.asSharedFlow()
    override fun onEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.StartInitProcess -> {
                viewModelScope.launch {
                    when (val initOps = initialOperationUseCase()) {
                        is Resource.Success -> {
                            if (initOps.data == true) {
                                _splashFlow.emit(SplashScreenFlow.RedirectedToEditor)
                            }
                            else {
                                _splashFlow.emit(SplashScreenFlow.RetryInitOps)
                            }
                        }
                        is Resource.Error -> {
                            _splashFlow.emit(SplashScreenFlow.RetryInitOps)
                        }

                    }
                }
            }
        }
    }


}