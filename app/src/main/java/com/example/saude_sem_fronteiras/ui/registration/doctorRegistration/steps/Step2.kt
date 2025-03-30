package com.example.saude_sem_fronteiras.ui.registration.doctorRegistration.steps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.saude_sem_fronteiras.ui.components.CustomTextField
import com.example.saude_sem_fronteiras.ui.registration.doctorRegistration.DoctorRegistrationViewModel
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

@Composable
fun StepTwo(viewModel: DoctorRegistrationViewModel) {
    SaudesemfronteirasTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val cep by viewModel.cep.collectAsState()
            val estado by viewModel.estado.collectAsState()
            val cidade by viewModel.cidade.collectAsState()
            val bairro by viewModel.bairro.collectAsState()
            val rua by viewModel.rua.collectAsState()
            val complemento by viewModel.complemento.collectAsState()

            CustomTextField("CEP", cep) { viewModel.onCepChanged(it) }
            CustomTextField("Estado", estado) { viewModel.onEstadoChanged(it) }
            CustomTextField("Cidade", cidade) { viewModel.onCidadeChanged(it) }
            CustomTextField("Bairro", bairro) { viewModel.onBairroChanged(it) }
            CustomTextField("Rua e Número", rua) { viewModel.onRuaChanged(it) }
            CustomTextField("Complemento", complemento) { viewModel.onComplementoChanged(it) }
        }
    }
}