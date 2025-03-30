package com.example.saude_sem_fronteiras.ui.registration.doctorRegistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

class DoctorRegistrationActivity : ComponentActivity() {
    private val viewModel: DoctorRegistrationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaudesemfronteirasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DoctorRegistrationScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun DoctorRegistrationScreen(modifier: Modifier = Modifier) {
        val pagerState = rememberPagerState(pageCount = {
            3
        })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                DoctorRegistrationPager(pagerState, viewModel)
            }
            DoctorNavigationButtons(pagerState)
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DoctorRegistrationScreenPreview() {
        SaudesemfronteirasTheme {
            DoctorRegistrationScreen()
        }
    }
}
