package com.efecjo.photoeditor.domain.use_case.splash

import com.efecjo.photoeditor.domain.repository.AppRepository
import com.efecjo.photoeditor.util.Resource
import com.efecjo.photoeditor.util.SimpleResource

class InitOperationsUseCase(
    private val appRepository: AppRepository
) {

    suspend operator fun invoke() : Resource<Boolean>{
        return appRepository.initialOperations()
    }
}