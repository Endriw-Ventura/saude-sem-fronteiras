package com.example.saude_sem_fronteiras.domain.usecase

import com.example.saude_sem_fronteiras.data.repository.AppHealthRepository
import com.example.saude_sem_fronteiras.data.response.LoginResponse
import com.example.saude_sem_fronteiras.data.util.Error
import com.example.saude_sem_fronteiras.data.util.RequestResult
import com.example.saude_sem_fronteiras.domain.repository.HealthRepository

fun interface LogInUseCase {
    suspend fun invoke(userName: String, password: String): RequestResult<LoginResponse, Error>
}

class LogIn(
    private val repository: HealthRepository = AppHealthRepository()
): LogInUseCase {
    override suspend fun invoke(userName: String, password: String): RequestResult<LoginResponse, Error> {
        return repository.logIn(userName, password)
    }
}