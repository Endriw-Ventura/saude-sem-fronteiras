package com.example.saude_sem_fronteiras.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.ui.components.CustomButton
import com.example.saude_sem_fronteiras.ui.registration.doctorRegistration.DoctorRegistrationActivity
import com.example.saude_sem_fronteiras.ui.registration.userRegistration.UserRegistrationActivity
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaudesemfronteirasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun RegistrationScreen(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center

        ) {
            Column (
                modifier = Modifier .padding(16.dp)
            ){
                CustomButton("Usuário", {
                    startActivity(Intent(this@RegistrationActivity, UserRegistrationActivity::class.java))
                })
                Spacer(modifier = Modifier.height(48.dp))
                CustomButton("Profissional", {
                    startActivity(Intent(this@RegistrationActivity, DoctorRegistrationActivity::class.java))
                })
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun RegistrationScreenPreview() {
        SaudesemfronteirasTheme {
            RegistrationScreen()
        }
    }
}