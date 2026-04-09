package com.example.vk.android.homework.data.appdetails.local

import com.example.vk.android.homework.domain.appdetails.App

class AppDetailsEntityMapper {

    fun toEntity(domain: App): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category,
        ageRating = domain.ageRating,
        size = domain.size,
        iconUrl = domain.iconUrl,
        screenshots = domain.screenshotUrlList.joinToString(","),
        description = domain.description
    )

    fun toDomain(entity: AppDetailsEntity): App = App(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = entity.category,
        ageRating = entity.ageRating,
        size = entity.size,
        iconUrl = entity.iconUrl,
        screenshotUrlList = entity.screenshots?.split(",") ?: emptyList(),
        description = entity.description
    )
}