package com.example.saude_sem_fronteiras.data.repository

import com.example.saude_sem_fronteiras.data.response.LoginResponse
import com.example.saude_sem_fronteiras.domain.repository.HealthRepository
import kotlinx.coroutines.delay

class AppHealthRepository: HealthRepository {
    override suspend fun logIn(username: String, password: String): LoginResponse {
        delay(1000)
        return LoginResponse(
            token = "mock-token"
        )
    }
}