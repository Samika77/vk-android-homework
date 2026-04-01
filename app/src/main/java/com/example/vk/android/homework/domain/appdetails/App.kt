package com.example.vk.android.homework.domain.appdetails

import com.example.vk.android.homework.domain.Category

data class App(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String
)