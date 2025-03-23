package com.example.saude_sem_fronteiras.data.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.saude_sem_fronteiras.domain.storage.AuthStorage
import androidx.core.content.edit


private const val AUTH_TOKEN = "auth_token"

class AuthStorageImpl(
    context: Context,
    private val prefs: SharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
) : AuthStorage {
    override fun saveToken(token: String) {
        prefs.edit { putString(AUTH_TOKEN, token) }
    }

    override fun getToken(): String? {
        return prefs.getString(AUTH_TOKEN, null)
    }
}