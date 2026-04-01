package com.example.vk.android.homework.domain.applist

interface AppListRepository {
    suspend fun getAppList(): List<AppItem>
}