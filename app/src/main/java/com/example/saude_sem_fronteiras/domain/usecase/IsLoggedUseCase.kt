package com.example.saude_sem_fronteiras.domain.usecase

import com.example.saude_sem_fronteiras.data.storage.AuthStorageImpl
import com.example.saude_sem_fronteiras.di.AppContextProvider
import com.example.saude_sem_fronteiras.domain.storage.AuthStorage

fun interface IsLoggedUseCase {
     suspend fun invoke(): Boolean
}

class IsLogged(
    private val authStorage: AuthStorage = AuthStorageImpl(AppContextProvider.context)
): IsLoggedUseCase {
    override suspend fun invoke(): Boolean {
        return authStorage.getToken().isNullOrBlank().not()
    }

}