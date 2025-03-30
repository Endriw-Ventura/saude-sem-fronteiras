package com.example.saude_sem_fronteiras.data.repository

import com.example.saude_sem_fronteiras.data.api.HealthApi
import com.example.saude_sem_fronteiras.data.request.LoginRequest
import com.example.saude_sem_fronteiras.data.response.LoginResponse
import com.example.saude_sem_fronteiras.data.util.provideRetrofitApi
import com.example.saude_sem_fronteiras.data.util.safeApiCall
import com.example.saude_sem_fronteiras.domain.repository.HealthRepository
import kotlinx.coroutines.delay

class AppHealthRepository(
    val api: HealthApi = provideRetrofitApi()
): HealthRepository {
    override suspend fun logIn(credentials: LoginRequest) = safeApiCall {
        api.logIn(credentials)
        delay(1000)
        LoginResponse(
            token = "mock-token"
        )
    }
}