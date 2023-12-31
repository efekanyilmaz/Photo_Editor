package com.efecjo.photoeditor.presentation.editor

sealed class EditorEvent {
    object StartScreen : EditorEvent()
    object OnNewPictureSelectFromGallery : EditorEvent()
    object OnNewPictureSelectFromCamera : EditorEvent()
    object OnCropPicture : EditorEvent()
    object OnRotatePicture : EditorEvent()
    object OnSavePicture : EditorEvent()
    object OnSharePicture : EditorEvent()
    object OnBack : EditorEvent()
    object OnUndo : EditorEvent()
    object OnRedo : EditorEvent()
    object OnBrush : EditorEvent()
    object OnEraser : EditorEvent()
    object OnText : EditorEvent()
    object OnFilter : EditorEvent()
    object OnEmoji : EditorEvent()
    object OnSticker : EditorEvent()
    object OnFrame : EditorEvent()
    object OnBrightness : EditorEvent()
    object OnSaturation : EditorEvent()
    object OnContrast : EditorEvent()
    object OnExposure : EditorEvent()
    object OnShadow : EditorEvent()
    object OnHighlight : EditorEvent()
    object OnTemperature : EditorEvent()
    object OnVignette : EditorEvent()
    object OnSharpen : EditorEvent()
    object OnBlur : EditorEvent()
    object OnMirror : EditorEvent()
    object OnFlip : EditorEvent()
    object OnReset : EditorEvent()


}