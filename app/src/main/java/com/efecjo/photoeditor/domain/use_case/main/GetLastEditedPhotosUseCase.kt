package com.efecjo.photoeditor.domain.use_case.main

import com.efecjo.photoeditor.domain.ImageListItem
import com.efecjo.photoeditor.domain.repository.MainRepository
import com.efecjo.photoeditor.util.Resource

class GetLastEditedPhotosUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke() : Resource<List<ImageListItem>> {
        return repository.getLastUpdatedPhotos()
    }
}