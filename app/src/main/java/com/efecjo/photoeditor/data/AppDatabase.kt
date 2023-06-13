package com.efecjo.photoeditor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.efecjo.photoeditor.data.database.photos.PhotosDao
import com.efecjo.photoeditor.data.database.photos.PhotosEntity

@Database(entities = [PhotosEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photosDao(): PhotosDao
}
const val databaseName = "app_database_PHOTO_EDITOR"
