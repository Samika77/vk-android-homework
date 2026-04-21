package com.example.vk.android.homework.di

import com.example.vk.android.homework.data.appdetails.AppDetailsApi
import com.example.vk.android.homework.data.applist.AppListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl("http://185.103.109.134/")
        .client(okHttpClient)
        .addConverterFactory(
            json.asConverterFactory(
                contentType = "application/json".toMediaType()
            )
        )
        .build()

    @Provides
    fun provideAppListApi(retrofit: Retrofit): AppListApi = retrofit.create()

    @Provides
    fun provideAppDetailsApi(retrofit: Retrofit): AppDetailsApi = retrofit.create()
}