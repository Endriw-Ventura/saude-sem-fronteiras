package com.example.saude_sem_fronteiras.ui.registration.doctorRegistration

import androidx.lifecycle.ViewModel
import com.example.saude_sem_fronteiras.model.Option
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DoctorRegistrationViewModel(): ViewModel() {
    private val _nome = MutableStateFlow("")
    val nome: StateFlow<String> = _nome

    private val _sobrenome = MutableStateFlow("")
    val sobrenome: StateFlow<String> = _sobrenome

    private val _cpf = MutableStateFlow("")
    val cpf: StateFlow<String> = _cpf

    private val _registro = MutableStateFlow("")
    val registro: StateFlow<String> = _registro

    private val _dataNascimento = MutableStateFlow("")
    val dataNascimento: StateFlow<String> = _dataNascimento

    private val _genero = MutableStateFlow("")
    val genero: StateFlow<String> = _genero

    private val _especialidade = MutableStateFlow<Option?>(null)
    val especialidade: StateFlow<Option?> = _especialidade

    private val _horaInicial = MutableStateFlow("")
    val horaInicial: StateFlow<String> = _horaInicial

    private val _horaFinal = MutableStateFlow("")
    val horaFinal: StateFlow<String> = _horaFinal

    private val _diasEscolhidos = MutableStateFlow(listOf<String>())
    val diasEscolhidos: StateFlow<List<String>> = _diasEscolhidos

    fun onNomeChanged(value: String) {
        _nome.value = value
    }

    fun onDiasEscolhidosChanged(dia: String) {
        _diasEscolhidos.value = if (_diasEscolhidos.value.contains(dia)) {
            _diasEscolhidos.value - dia
        } else {
            _diasEscolhidos.value + dia
        }
    }

    fun onHoraInicalChanged(value: String) {
        _horaInicial.value = value
    }

    fun onHoraFinalChanged(value: String) {
        _horaFinal.value = value
    }

    fun onSobrenomeChanged(value: String) {
        _sobrenome.value = value
    }

    fun onCpfChanged(value: String) {
        _cpf.value = value
    }

    fun onRegistroChanged(value: String) {
        _registro.value = value
    }

    fun onDataNascimentoChanged(value: String) {
        _dataNascimento.value = value
    }

    fun onGeneroChanged(value: String) {
        _genero.value = value
    }

    fun onEspecialidadeChanged(option: Option) {
        _especialidade.value = option
    }
}