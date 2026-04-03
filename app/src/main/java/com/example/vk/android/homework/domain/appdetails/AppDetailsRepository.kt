package com.example.vk.android.homework.domain.appdetails

interface AppDetailsRepository {
    suspend fun get(id: String) : App
}