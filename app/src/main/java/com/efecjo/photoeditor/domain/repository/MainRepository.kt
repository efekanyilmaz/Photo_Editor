package com.efecjo.photoeditor.domain.repository

import com.efecjo.photoeditor.domain.ImageListItem
import com.efecjo.photoeditor.util.Resource

interface MainRepository {
    suspend fun getLastUpdatedPhotos() : Resource<List<ImageListItem>>
}