package com.example.saude_sem_fronteiras.ui.registration.userRegistration.steps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.saude_sem_fronteiras.ui.components.CustomTextField
import com.example.saude_sem_fronteiras.ui.registration.userRegistration.UserRegistrationViewModel
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

@Composable
fun StepOne(viewModel: UserRegistrationViewModel) {
    SaudesemfronteirasTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            val nome by viewModel.nome.collectAsState()
            val sobrenome by viewModel.sobrenome.collectAsState()
            val cpf by viewModel.cpf.collectAsState()
            val dataNascimento by viewModel.dataNascimento.collectAsState()
            val genero by viewModel.genero.collectAsState()

            Column(modifier = Modifier.fillMaxSize()) {
                CustomTextField("Nome", nome) { viewModel.onNomeChanged(it) }
                CustomTextField("Sobrenome", sobrenome) { viewModel.onSobrenomeChanged(it) }
                CustomTextField("CPF", cpf) { viewModel.onCpfChanged(it) }
                CustomTextField("Data de nascimento", dataNascimento) { viewModel.onDataNascimentoChanged(it) }
                CustomTextField("Gênero", genero) { viewModel.onGeneroChanged(it) }
            }
        }
    }
}