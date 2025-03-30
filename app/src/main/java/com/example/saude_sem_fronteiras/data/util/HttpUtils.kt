package com.example.saude_sem_fronteiras.data.util

import com.example.saude_sem_fronteiras.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}

inline fun <reified T> provideRetrofitApi(baseUrl: String = BuildConfig.BASE_URL): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(T::class.java)
}