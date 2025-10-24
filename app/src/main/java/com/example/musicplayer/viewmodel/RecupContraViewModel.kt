package com.example.musicplayer.viewmodel

import androidx.compose.runtime.mutableStateOf

class RecupContraViewModel: ViewModel() {
    var correo = mutableStateOf("")
    var nuevacontra = mutableStateOf("")
    var confirmarcontra = mutableStateOf("")
    var loginError = mutableStateOf("")

    fun login(onSuccess: () -> Unit) {
        if (correo.value == "admin@gmail.com" && nuevacontra.value == "1234" && confirmarcontra.value == "1234") {
            loginError.value = ""
            onSuccess()
        } else {
            loginError.value = "Llene todos los campos por favor"
        }
    }
}