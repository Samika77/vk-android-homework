package com.example.vk.android.homework.domain.appdetails

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun get(id: String) : Flow<App>
}