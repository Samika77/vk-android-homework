package com.example.vk.android.homework.data.appdetails

import retrofit2.http.GET
import retrofit2.http.Path

interface AppDetailsApi {
    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}