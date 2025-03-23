package com.example.saude_sem_fronteiras.domain.repository

import com.example.saude_sem_fronteiras.data.response.LoginResponse

interface HealthRepository {
    suspend fun logIn(
        username: String,
        password: String
    ): LoginResponse
}