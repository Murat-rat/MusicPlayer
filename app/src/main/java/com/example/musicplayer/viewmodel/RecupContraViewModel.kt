package com.example.musicplayer.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RecupContraViewModel: ViewModel() {

        var correo = mutableStateOf("")
        var nuevacontra = mutableStateOf("")
        var confirmarcontra = mutableStateOf("")
        var loginError = mutableStateOf("")

        fun recupContra(onSuccess: () -> Unit) {
            if (correo.value == "admin" && nuevacontra.value == "1234" && confirmarcontra.value == "1234") {
                loginError.value = ""
                onSuccess()
            } else {
                loginError.value = "Llene todos los campos porfavor"
            }
        }
    }
