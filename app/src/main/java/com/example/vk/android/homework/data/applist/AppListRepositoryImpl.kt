package com.example.vk.android.homework.data.applist

import com.example.vk.android.homework.domain.applist.AppItem
import com.example.vk.android.homework.domain.applist.AppListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppListRepositoryImpl (
    private val mapper: AppListMapper,
    private val api: AppListApi
) : AppListRepository {
    override suspend fun getAppList(): List<AppItem> {
        return withContext(Dispatchers.IO) {
            val dto = api.getAppList()
            mapper.toDomain(dto)
        }
    }
}