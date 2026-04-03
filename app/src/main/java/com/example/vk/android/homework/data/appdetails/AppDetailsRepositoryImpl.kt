package com.example.vk.android.homework.data.appdetails

import com.example.vk.android.homework.domain.appdetails.App
import com.example.vk.android.homework.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi,
) : AppDetailsRepository {
    override suspend fun get(id: String): App {
        val dto = api.get(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}