package com.efecjo.photoeditor.util

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

object GalleryLauncherFlow {
    private val _galleryFlow = MutableSharedFlow<GalleryLauncherFlowModel>(replay = 1)
    val galleryFlow: SharedFlow<GalleryLauncherFlowModel> = _galleryFlow

    suspend fun setGalleryState(value: GalleryLauncherFlowModel) {
        _galleryFlow.emit(value)
    }
}

data class GalleryLauncherFlowModel(
    val uri : String = ""
)