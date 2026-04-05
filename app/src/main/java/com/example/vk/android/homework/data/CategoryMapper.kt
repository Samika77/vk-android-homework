package com.example.vk.android.homework.data

import com.example.vk.android.homework.domain.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun toDomain(category: String): Category = when (category.trim()) {
        "Производительность" -> Category.PRODUCTIVITY
        "Здоровье и фитнес" -> Category.HEALTH_FITNESS
        "Фото и видео" -> Category.PHOTO_VIDEO
        "Еда и напитки" -> Category.FOOD_DRINKS
        "Образование" -> Category.EDUCATION
        "Образ жизни" -> Category.LIFESTYLE
        "Шопинг" -> Category.SHOPPING
        "Новости" -> Category.NEWS
        "Музыка" -> Category.MUSIC
        "Игры" -> Category.GAMES
        "Финансы" -> Category.FINANCE
        "Утилиты" -> Category.UTILITY
        "Навигация" -> Category.NAVIGATION
        "Общение" -> Category.COMMUNICATION
        "Бизнес" -> Category.BUSINESS
        "Погода" -> Category.WEATHER
        "Развлечения" -> Category.ENTERTAINMENT
        "Книги и справочники" -> Category.BOOKS
        else -> Category.OTHER
    }
}