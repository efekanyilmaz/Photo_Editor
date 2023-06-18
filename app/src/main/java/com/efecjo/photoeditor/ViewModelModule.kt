package com.efecjo.photoeditor

import android.content.Context
import com.efecjo.photoeditor.domain.repository.AppRepository
import com.efecjo.photoeditor.domain.repository.MainRepository
import com.efecjo.photoeditor.domain.use_case.main.GetLastEditedPhotosUseCase
import com.efecjo.photoeditor.domain.use_case.splash.InitOperationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @ViewModelScoped
    fun provideGetLastEditedPhotosUseCase(
        mainRepository: MainRepository
    ): GetLastEditedPhotosUseCase {
        return GetLastEditedPhotosUseCase(mainRepository)
    }

}