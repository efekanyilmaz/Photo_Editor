package com.efecjo.photoeditor.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.efecjo.photoeditor.presentation.theme.DarkBlue

@Composable
fun MenuItemIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

) {
    IconButton(
        onClick = onClick,
        modifier = modifier

    ) {
        Icon(
            imageVector = Icons.TwoTone.Menu,
            tint = DarkBlue,
            contentDescription = "Menu"
        )
    }
}