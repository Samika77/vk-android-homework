package com.example.vk.android.homework.data.appdetails.local

import androidx.room.TypeConverter
import com.example.vk.android.homework.domain.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}