package com.efecjo.photoeditor.data.database.photos

import androidx.room.*

@Dao
interface PhotosDao {
    @Insert
    suspend fun insert(photosEntity: PhotosEntity)

    @Update
    suspend fun update(photosEntity: PhotosEntity)

    @Delete
    suspend fun delete(photosEntity: PhotosEntity)

    @Query("SELECT * FROM photos")
    fun getAll(): List<PhotosEntity>

    @Query("SELECT * FROM photos WHERE id = :id")
    suspend fun getPhotosById(id: Int): List<PhotosEntity>
}