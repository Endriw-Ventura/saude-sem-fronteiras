package com.example.saude_sem_fronteiras.ui.registration.doctorRegistration.steps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.saude_sem_fronteiras.data.mocks.MockOptions
import com.example.saude_sem_fronteiras.ui.components.CustomSelect
import com.example.saude_sem_fronteiras.ui.components.CustomTextField
import com.example.saude_sem_fronteiras.ui.components.CustomTimePicker
import com.example.saude_sem_fronteiras.ui.components.WeekDaySelector
import com.example.saude_sem_fronteiras.ui.registration.doctorRegistration.DoctorRegistrationViewModel
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

@Composable
fun StepTwo(viewModel: DoctorRegistrationViewModel) {
    SaudesemfronteirasTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val especialidade by viewModel.especialidade.collectAsState()
            val registro by viewModel.registro.collectAsState()
            val horaInicial by viewModel.horaInicial.collectAsState()
            val horaFinal by viewModel.horaFinal.collectAsState()
            val diasEscolhidos by viewModel.diasEscolhidos.collectAsState()
            val options = MockOptions.options

            CustomSelect(options, especialidade ) { viewModel.onEspecialidadeChanged(it) }
            CustomTextField("Número de registro", registro) { viewModel.onRegistroChanged(it) }
            CustomTimePicker("Horário de início", horaInicial) { viewModel.onHoraInicalChanged(it) }
            CustomTimePicker("Horário de fim", horaFinal) { viewModel.onHoraFinalChanged(it) }
            WeekDaySelector(diasEscolhidos, onDaySelected = { dia, isChecked ->
                viewModel.onDiasEscolhidosChanged(dia)
            })
        }
    }
}