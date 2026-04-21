package com.example.vk.android.homework.data.appdetails.local

import androidx.room.TypeConverter

class ScreenshotConverter {
    @TypeConverter
    fun fromScreenshotList(list: List<String>?): String? =
        list?.joinToString(",")

    @TypeConverter
    fun toScreenshotList(data: String?): List<String> =
        data?.split(",") ?: emptyList()
}