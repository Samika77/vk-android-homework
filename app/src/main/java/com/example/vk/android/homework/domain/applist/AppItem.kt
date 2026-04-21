package com.example.vk.android.homework.domain.applist

import com.example.vk.android.homework.domain.Category

data class AppItem(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
    val icon: String
)