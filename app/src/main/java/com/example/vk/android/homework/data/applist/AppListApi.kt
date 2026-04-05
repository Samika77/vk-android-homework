package com.example.vk.android.homework.data.applist

import retrofit2.http.GET

interface AppListApi {
    @GET("catalog")
    suspend fun getAppList(): List<AppItemDto>
}