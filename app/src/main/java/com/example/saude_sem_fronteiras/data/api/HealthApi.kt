package com.example.saude_sem_fronteiras.data.api

import com.example.saude_sem_fronteiras.data.request.LoginRequest
import com.example.saude_sem_fronteiras.data.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface HealthApi {

    @POST("/login")
    suspend fun logIn(
        @Body credentials: LoginRequest
    ): LoginResponse
}