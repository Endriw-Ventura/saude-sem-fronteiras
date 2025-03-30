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
fun StepThree(viewModel: UserRegistrationViewModel) {
    SaudesemfronteirasTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            val tipoSanguineo by viewModel.tipoSanguineo.collectAsState()
            val alergias by viewModel.alergias.collectAsState()
            val medicamentos by viewModel.medicamentos.collectAsState()
            val telefone by viewModel.telefone.collectAsState()
            val contatoEmergencial by viewModel.contatoEmergencial.collectAsState()

            CustomTextField("Tipo sanguíneo", tipoSanguineo) { viewModel.onTipoSanguineoChanged(it) }
            CustomTextField("Alergias", alergias) { viewModel.onAlergiasChanged(it) }
            CustomTextField("Medicamentos", medicamentos) { viewModel.onMedicamentosChanged(it) }
            CustomTextField("Telefone", telefone) { viewModel.onTelefoneChanged(it) }
            CustomTextField("Contato de emergência", contatoEmergencial) { viewModel.onContatoEmergencialChanged(it) }
        }
    }
}