package com.efecjo.photoeditor

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.efecjo.photoeditor.data.AppDatabase
import com.efecjo.photoeditor.data.AppRepositoryImpl
import com.efecjo.photoeditor.data.database.photos.PhotosDao
import com.efecjo.photoeditor.data.databaseName
import com.efecjo.photoeditor.domain.repository.AppRepository
import com.efecjo.photoeditor.domain.use_case.splash.InitOperationsUseCase
import com.efecjo.photoeditor.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext appContext: Context
    ): SharedPreferences {
        return appContext.getSharedPreferences(AppConstants.SHARED_PREF_NAME, MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            databaseName
        ).build()
    }

    @Provides
    @Singleton
    fun provideAppRepository(
        appDatabase: AppDatabase
    ): AppRepository {
        return AppRepositoryImpl(appDatabase)
    }



    @Provides
    fun providePhotosDao(appDatabase: AppDatabase): PhotosDao {
        return appDatabase.photosDao()
    }
}