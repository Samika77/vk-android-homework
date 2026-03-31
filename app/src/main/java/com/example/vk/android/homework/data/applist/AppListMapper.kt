package com.example.vk.android.homework.data.applist

import com.example.vk.android.homework.domain.applist.AppItem

class AppListMapper {
    fun toDomain(dtoList: List<AppItemDto>): List<AppItem> =
        dtoList.map { dto ->
            AppItem(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                category = dto.category,
                icon = dto.icon
            )
        }
}