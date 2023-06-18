package com.efecjo.photoeditor.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.efecjo.photoeditor.presentation.theme.ColorPalette

@Composable
fun MainScreenButton(
    onClick : () -> Unit,
    colorPalette: ColorPalette,
    text: String,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        enabled = true,
        modifier = modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(0.5f)
            .padding(16.dp)

    ){
        colorPalette.onPrimary?.let { Text(text = text, color = it) }
    }
}