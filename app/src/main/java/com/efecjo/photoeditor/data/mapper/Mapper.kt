package com.efecjo.photoeditor.data.mapper

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import com.efecjo.photoeditor.data.database.photos.PhotosEntity
import com.efecjo.photoeditor.domain.ImageListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun List<PhotosEntity>.mapToImageListItem(context : Context) : List<ImageListItem> = withContext(Dispatchers.IO) {
    return@withContext map {
        ImageListItem(createImageBitmap(context,it.url))
    }
}


suspend fun createImageBitmap(context: Context, url: String): ImageBitmap {
    // Create an `ImageRequest` to load the image from the given URL.
    val request = ImageRequest.Builder(context)
        .data(url)
        .build()

    // Use `ImageLoader` to load the image and decode it into a `Bitmap`.
    val imageBitmap = ImageLoader(context).execute(request).drawable?.toBitmap()

    // Return the `Bitmap`.
    if (imageBitmap != null) {
        return imageBitmap.asImageBitmap()
    }
    return ImageBitmap(1,1)
}