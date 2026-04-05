package com.example.vk.android.homework.data.applist

import kotlinx.serialization.Serializable

@Serializable
data class AppItemDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String
)
