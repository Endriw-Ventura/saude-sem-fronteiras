package com.example.saude_sem_fronteiras.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saude_sem_fronteiras.domain.usecase.LogIn
import com.example.saude_sem_fronteiras.domain.usecase.LogInUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val logIn: LogInUseCase = LogIn()
): ViewModel() {

    private val _loading = MutableStateFlow(false)

    private val loading: StateFlow<Boolean> get() = _loading

    private val _onLoginSuccess = MutableStateFlow(false)
    private val onLoginSuccess: StateFlow<Boolean> get() = _onLoginSuccess

    fun startLogIn(userName: String, password: String) {
        _loading.value = true
        viewModelScope.launch {
            logIn(userName = userName, password = password)
                .onSuccess {
                    _loading.value = false
                    _onLoginSuccess.value = true
                }
                .onError {
                    _onLoginSuccess.value = false
                    _loading.value = false
                }
        }
    }
}