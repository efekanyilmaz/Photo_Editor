package com.efecjo.photoeditor.presentation.splash

import androidx.lifecycle.ViewModel
import com.efecjo.photoeditor.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel<SplashEvent>(){
    override fun onEvent(event: SplashEvent) {
        when(event){
            is SplashEvent.StartInitProcess -> {

            }
        }
    }


}