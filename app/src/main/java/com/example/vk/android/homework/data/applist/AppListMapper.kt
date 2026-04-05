package com.example.vk.android.homework.data.applist

import com.example.vk.android.homework.data.CategoryMapper
import com.example.vk.android.homework.domain.applist.AppItem
import jakarta.inject.Inject

class AppListMapper @Inject constructor(
    private val categoryMapper: CategoryMapper,
) {
    fun toDomain(dtoList: List<AppItemDto>): List<AppItem> =
        dtoList.map { dto ->
            AppItem(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                category = categoryMapper.toDomain(dto.category),
                icon = dto.iconUrl
            )
        }
}