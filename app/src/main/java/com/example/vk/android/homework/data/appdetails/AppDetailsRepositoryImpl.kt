package com.example.vk.android.homework.data.appdetails

import com.example.vk.android.homework.data.appdetails.local.AppDetailsDao
import com.example.vk.android.homework.data.appdetails.local.AppDetailsEntityMapper
import com.example.vk.android.homework.domain.appdetails.App
import com.example.vk.android.homework.domain.appdetails.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class AppDetailsRepositoryImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper,
) : AppDetailsRepository {
    override suspend fun get(id: String): Flow<App> {
        return dao.getAppDetails(id).map { entity ->
            if (entity != null) {
                entityMapper.toDomain(entity)
            } else {
                val dto = api.getAppDetails(id)
                val domain = mapper.toDomain(dto)
                val entity = entityMapper.toEntity(domain)
                withContext(Dispatchers.IO) {
                    dao.insertAppDetails(entity)
                }
                domain
            }
        }
    }
}