package com.efecjo.photoeditor.presentation.editor

import androidx.lifecycle.ViewModel
import com.efecjo.photoeditor.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditorViewModel @Inject constructor() : BaseViewModel<EditorEvent>() {
    override fun onEvent(event: EditorEvent) {
        when (event) {
            EditorEvent.OnBack -> {

            }
            EditorEvent.OnBlur -> {
            }

            EditorEvent.OnBrightness -> {}
            EditorEvent.OnBrush -> {
            }

            EditorEvent.OnContrast -> {}
            EditorEvent.OnCropPicture -> {}
            EditorEvent.OnEmoji -> {}
            EditorEvent.OnEraser -> {}
            EditorEvent.OnExposure -> {}
            EditorEvent.OnFilter -> {}
            EditorEvent.OnFlip -> {}
            EditorEvent.OnFrame -> {}
            EditorEvent.OnHighlight -> {}
            EditorEvent.OnMirror -> {
            }
            EditorEvent.OnNewPictureSelectFromCamera -> {}
            EditorEvent.OnNewPictureSelectFromGallery -> {}
            EditorEvent.OnRedo -> {}
            EditorEvent.OnReset -> {
            }
            EditorEvent.OnRotatePicture -> {}
            EditorEvent.OnSaturation -> {}
            EditorEvent.OnSavePicture -> {}
            EditorEvent.OnShadow -> {}
            EditorEvent.OnSharePicture -> {}
            EditorEvent.OnSharpen -> {}
            EditorEvent.OnSticker -> {}
            EditorEvent.OnTemperature -> {}
            EditorEvent.OnText -> {}
            EditorEvent.OnUndo -> {}
            EditorEvent.OnVignette -> {}
            EditorEvent.StartScreen -> {}
        }
    }

}