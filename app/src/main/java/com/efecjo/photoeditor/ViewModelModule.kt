package com.efecjo.photoeditor

import com.efecjo.photoeditor.domain.repository.AppRepository
import com.efecjo.photoeditor.domain.use_case.splash.InitOperationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideInitOperationsUseCase(
        appRepository: AppRepository
    ): InitOperationsUseCase {
        return InitOperationsUseCase(appRepository)
    }
}