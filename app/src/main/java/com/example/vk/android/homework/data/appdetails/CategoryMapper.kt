package com.example.vk.android.homework.data.appdetails

import com.example.vk.android.homework.domain.appdetails.Category

class CategoryMapper {
    fun toDomain(category: String): Category = when (category) {
        "App" -> Category.APP
        "Game" -> Category.GAME
        else -> throw IllegalStateException("Unsupported category type: $category")
    }
}