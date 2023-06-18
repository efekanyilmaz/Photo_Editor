package com.efecjo.photoeditor.data

import android.content.Context
import com.efecjo.photoeditor.data.mapper.mapToImageListItem
import com.efecjo.photoeditor.domain.ImageListItem
import com.efecjo.photoeditor.domain.repository.MainRepository
import com.efecjo.photoeditor.util.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val context: Context
) : MainRepository {
    override suspend fun getLastUpdatedPhotos(): Resource<List<ImageListItem>> {
        return Resource.Success(database.photosDao().getAll().mapToImageListItem(context))
    }
}