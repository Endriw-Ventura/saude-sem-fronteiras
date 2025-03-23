package com.example.saude_sem_fronteiras.domain.usecase

import com.example.saude_sem_fronteiras.data.repository.AppHealthRepository
import com.example.saude_sem_fronteiras.data.response.LoginResponse
import com.example.saude_sem_fronteiras.data.storage.AuthStorageImpl
import com.example.saude_sem_fronteiras.data.util.Error
import com.example.saude_sem_fronteiras.data.util.RequestResult
import com.example.saude_sem_fronteiras.di.AppContextProvider
import com.example.saude_sem_fronteiras.domain.repository.HealthRepository
import com.example.saude_sem_fronteiras.domain.storage.AuthStorage

fun interface LogInUseCase {
    suspend operator fun invoke(userName: String, password: String): RequestResult<LoginResponse, Error>
}

class LogIn(
    private val repository: HealthRepository = AppHealthRepository(),
    private val authStorage: AuthStorage = AuthStorageImpl(AppContextProvider.context)
): LogInUseCase {
    override suspend fun invoke(userName: String, password: String): RequestResult<LoginResponse, Error> {
        return repository.logIn(userName, password).mapSuccess { loginResponse ->
            authStorage.saveToken(loginResponse.token)
            loginResponse
        }
    }
}