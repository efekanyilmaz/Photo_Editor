package com.efecjo.photoeditor.data

import com.efecjo.photoeditor.domain.repository.AppRepository
import com.efecjo.photoeditor.util.Resource
import com.efecjo.photoeditor.util.SimpleResource
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val database: AppDatabase
) : AppRepository {

    override suspend fun initialOperations() : Resource<Boolean> {
        return Resource.Success(true)
    }
 }