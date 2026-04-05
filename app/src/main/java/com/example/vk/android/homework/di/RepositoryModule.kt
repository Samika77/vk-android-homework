package com.example.vk.android.homework.di

import com.example.vk.android.homework.data.appdetails.AppDetailsApi
import com.example.vk.android.homework.data.appdetails.AppDetailsMapper
import com.example.vk.android.homework.data.appdetails.AppDetailsRepositoryImpl
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
        api: AppDetailsApi
    ): AppDetailsRepository {
        return AppDetailsRepositoryImpl(mapper, api)
    }
}