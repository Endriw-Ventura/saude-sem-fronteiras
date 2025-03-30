package com.example.saude_sem_fronteiras.domain.repository

import com.example.saude_sem_fronteiras.data.request.LoginRequest
import com.example.saude_sem_fronteiras.data.response.LoginResponse
import com.example.saude_sem_fronteiras.data.util.Error
import com.example.saude_sem_fronteiras.data.util.RequestResult

interface HealthRepository {
    suspend fun logIn(
        credentials: LoginRequest
    ): RequestResult<LoginResponse, Error>
}