package com.example.vk.android.homework.data

import com.example.vk.android.homework.domain.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun toDomain(category: String): Category = when (category.trim()) {
        "Финансы" -> Category.FINANCE
        "Общение" -> Category.COMMUNICATION
        "Объявления и услуги" -> Category.SERVICES
        "Транспорт и навигация" -> Category.TRANSPORT
        "Развлечения" -> Category.ENTERTAINMENT
        "Полезные инструменты" -> Category.UTILITY
        else -> throw IllegalStateException("Unsupported category type: $category")
    }
}