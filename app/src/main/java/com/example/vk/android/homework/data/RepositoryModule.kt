package com.example.vk.android.homework.data

import com.example.vk.android.homework.data.appdetails.AppDetailsRepositoryImpl
import com.example.vk.android.homework.data.applist.AppListRepositoryImpl
import com.example.vk.android.homework.domain.appdetails.AppDetailsRepository
import com.example.vk.android.homework.domain.applist.AppListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindAppListRepository(impl: AppListRepositoryImpl): AppListRepository

    @Binds
    fun bindAppDetailsRepository(impl: AppDetailsRepositoryImpl): AppDetailsRepository
}