package com.efecjo.photoeditor

import android.app.Application
import com.efecjo.photoeditor.util.CustomDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PhotoEditorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(CustomDebugTree())
        }
    }
}