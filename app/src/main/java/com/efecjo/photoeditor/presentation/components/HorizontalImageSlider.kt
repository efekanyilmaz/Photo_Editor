package com.efecjo.photoeditor.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import android.content.Context
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.efecjo.photoeditor.domain.ImageListItem

@Composable
fun HorizontalImageSlider(
    items : List<ImageListItem>,
) {

    // Create a horizontal list of images.
    LazyColumn(modifier = Modifier.fillMaxWidth().background(Color.DarkGray)) {
        items(items) { photo ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(128.dp)
            ) {
                Image(
                    /*bitmap = photo.imageBitmap,*/
                    bitmap = ImageBitmap(12,12),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .aspectRatio(1f)
                )
            }
        }
    }
}
