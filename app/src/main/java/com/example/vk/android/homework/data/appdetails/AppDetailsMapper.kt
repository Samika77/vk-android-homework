package com.example.vk.android.homework.data.appdetails

import com.example.vk.android.homework.domain.appdetails.App

class AppDetailsMapper(
    private val categoryMapper: CategoryMapper,
) {
    fun toDomain(dto: AppDetailsDto): App = App(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = categoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        description = dto.description
    )
}