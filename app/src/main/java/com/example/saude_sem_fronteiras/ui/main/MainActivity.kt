package com.example.saude_sem_fronteiras.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import com.example.saude_sem_fronteiras.ui.theme.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.ui.RecoverActivity
import com.example.saude_sem_fronteiras.ui.registration.RegistrationActivity
import com.example.saude_sem_fronteiras.ui.components.CustomButton
import com.example.saude_sem_fronteiras.ui.components.CustomTextField
import com.example.saude_sem_fronteiras.ui.components.Loading
import com.example.saude_sem_fronteiras.ui.components.Logo
import com.example.saude_sem_fronteiras.ui.utils.collectAsStateLifecycleAware

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaudesemfronteirasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val isLoading = viewModel.loading.collectAsStateLifecycleAware()
                    if (isLoading.value){
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Loading()
                        }
                    } else {
                        Login(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                    val isLoginSuccess = viewModel.onLoginSuccess.collectAsStateLifecycleAware()

                    LaunchedEffect(isLoginSuccess.value) {
                        if (isLoginSuccess.value) {
                            Toast.makeText(this@MainActivity, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@MainActivity, "Falha no login", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun Login(modifier: Modifier = Modifier) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Logo()
                Spacer(modifier = Modifier.height(32.dp))
                CustomTextField("Usuário", username) { username = it }
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField("Senha", password) { password = it }
                Spacer(modifier = Modifier.height(32.dp))
                CustomButton("Entrar", {
                    viewModel.startLogIn(username, password)
                })
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton("Cadastrar", {
                    startActivity(Intent(this@MainActivity, RegistrationActivity::class.java))
                })
                Spacer(modifier = Modifier.height(8.dp))
                CustomButton("Esqueceu sua senha?", {
                    startActivity(Intent(this@MainActivity, RecoverActivity::class.java))
                })
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LoginPreview() {
        SaudesemfronteirasTheme {
            Login()
        }
    }
}


