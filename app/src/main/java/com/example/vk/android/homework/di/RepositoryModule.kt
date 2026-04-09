package com.example.vk.android.homework.di

import android.app.Application
import androidx.room.Room
import com.example.vk.android.homework.data.CategoryMapper
import com.example.vk.android.homework.data.appdetails.AppDetailsApi
import com.example.vk.android.homework.data.appdetails.AppDetailsMapper
import com.example.vk.android.homework.data.appdetails.AppDetailsRepositoryImpl
import com.example.vk.android.homework.data.appdetails.local.AppDatabase
import com.example.vk.android.homework.data.appdetails.local.AppDetailsDao
import com.example.vk.android.homework.data.appdetails.local.AppDetailsEntityMapper
import com.example.vk.android.homework.data.applist.AppListApi
import com.example.vk.android.homework.data.applist.AppListMapper
import com.example.vk.android.homework.data.applist.AppListRepositoryImpl
import com.example.vk.android.homework.domain.appdetails.AppDetailsRepository
import com.example.vk.android.homework.domain.applist.AppListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideAppListRepository(
        mapper: AppListMapper,
        api: AppListApi
    ): AppListRepository {
        return AppListRepositoryImpl(mapper, api)
    }

    @Provides
    fun provideAppDetailsRepository(
        mapper: AppDetailsMapper,
        api: AppDetailsApi,
        dao: AppDetailsDao,
        entityMapper: AppDetailsEntityMapper
    ): AppDetailsRepository {
        return AppDetailsRepositoryImpl(mapper, api, dao, entityMapper)
    }

    @Provides
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao {
        return database.appDetailsDao()
    }

    @Provides
    fun provideAppDetailsEntityMapper(): AppDetailsEntityMapper {
        return AppDetailsEntityMapper()
    }

    @Provides
    fun provideAppDetailsMapper(categoryMapper: CategoryMapper): AppDetailsMapper {
        return AppDetailsMapper(categoryMapper)
    }
}