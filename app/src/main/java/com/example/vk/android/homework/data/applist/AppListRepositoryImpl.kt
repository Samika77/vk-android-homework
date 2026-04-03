package com.example.vk.android.homework.data.applist

import com.example.vk.android.homework.domain.applist.AppItem
import com.example.vk.android.homework.domain.applist.AppListRepository
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor(
    private val mapper: AppListMapper,
    private val api: AppListApi
) : AppListRepository {
    override suspend fun getAppList(): List<AppItem> {
        val dto = api.getAppList()
        val domain = mapper.toDomain(dto)
        return domain
    }
}