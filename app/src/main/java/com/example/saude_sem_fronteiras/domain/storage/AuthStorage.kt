package com.example.saude_sem_fronteiras.domain.storage

interface AuthStorage {
    fun saveToken(token: String)
    fun getToken(): String?
}