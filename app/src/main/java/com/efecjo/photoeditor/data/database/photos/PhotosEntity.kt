package com.efecjo.photoeditor.data.database.photos

import androidx.room.Entity

@Entity(tableName = "photos")
data class PhotosEntity(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)