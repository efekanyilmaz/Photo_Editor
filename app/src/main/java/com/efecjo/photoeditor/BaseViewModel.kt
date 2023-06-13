package com.efecjo.photoeditor

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    abstract fun onEvent(event: T)
}