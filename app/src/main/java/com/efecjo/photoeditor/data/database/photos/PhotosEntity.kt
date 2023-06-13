package com.efecjo.photoeditor.data.database.photos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotosEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)