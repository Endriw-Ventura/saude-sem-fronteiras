package com.example.saude_sem_fronteiras.ui.registration.doctorRegistration

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DoctorRegistrationViewModel(): ViewModel() {
    private val _nome = MutableStateFlow("")
    val nome: StateFlow<String> = _nome

    private val _sobrenome = MutableStateFlow("")
    val sobrenome: StateFlow<String> = _sobrenome

    private val _cpf = MutableStateFlow("")
    val cpf: StateFlow<String> = _cpf

    private val _dataNascimento = MutableStateFlow("")
    val dataNascimento: StateFlow<String> = _dataNascimento

    private val _genero = MutableStateFlow("")
    val genero: StateFlow<String> = _genero

    private val _cep = MutableStateFlow("")
    val cep: StateFlow<String> = _cep

    private val _estado = MutableStateFlow("")
    val estado: StateFlow<String> = _estado

    private val _cidade = MutableStateFlow("")
    val cidade: StateFlow<String> = _cidade

    private val _bairro = MutableStateFlow("")
    val bairro: StateFlow<String> = _bairro

    private val _rua = MutableStateFlow("")
    val rua: StateFlow<String> = _rua

    private val _complemento = MutableStateFlow("")
    val complemento: StateFlow<String> = _complemento

    private val _tipoSanguineo = MutableStateFlow("")
    val tipoSanguineo: StateFlow<String> = _tipoSanguineo

    private val _alergias = MutableStateFlow("")
    val alergias: StateFlow<String> = _alergias

    private val _medicamentos = MutableStateFlow("")
    val medicamentos: StateFlow<String> = _medicamentos

    private val _telefone = MutableStateFlow("")
    val telefone: StateFlow<String> = _telefone

    private val _contatoEmergencial = MutableStateFlow("")
    val contatoEmergencial: StateFlow<String> = _contatoEmergencial

    fun onNomeChanged(value: String) {
        _nome.value = value
    }

    fun onSobrenomeChanged(value: String) {
        _sobrenome.value = value
    }

    fun onCpfChanged(value: String) {
        _cpf.value = value
    }

    fun onDataNascimentoChanged(value: String) {
        _dataNascimento.value = value
    }

    fun onGeneroChanged(value: String) {
        _genero.value = value
    }

    fun onCepChanged(value: String) {
        _cep.value = value
    }

    fun onEstadoChanged(value: String) {
        _estado.value = value
    }

    fun onCidadeChanged(value: String) {
        _cidade.value = value
    }

    fun onBairroChanged(value: String) {
        _bairro.value = value
    }

    fun onRuaChanged(value: String) {
        _rua.value = value
    }

    fun onComplementoChanged(value: String) {
        _complemento.value = value
    }

    fun onTipoSanguineoChanged(value: String) {
        _tipoSanguineo.value = value
    }

    fun onAlergiasChanged(value: String) {
        _alergias.value = value
    }

    fun onMedicamentosChanged(value: String) {
        _medicamentos.value = value
    }

    fun onTelefoneChanged(value: String) {
        _telefone.value = value
    }

    fun onContatoEmergencialChanged(value: String) {
        _contatoEmergencial.value = value
    }
}