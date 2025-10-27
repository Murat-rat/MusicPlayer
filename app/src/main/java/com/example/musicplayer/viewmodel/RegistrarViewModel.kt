package com.example.musicplayer.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


    class RegistrarViewModel: ViewModel() {

        var nombre = mutableStateOf("")
        var apellido = mutableStateOf("")
        var telefono = mutableStateOf("")
        var correo = mutableStateOf("")
        var contra = mutableStateOf("")
        var loginError = mutableStateOf("")

        fun registrar(onSuccess: () -> Unit) {
            if (nombre.value == "admin" && apellido.value == "1234" && apellido.value == "1234") {
                loginError.value = ""
                onSuccess()
            } else {
                loginError.value = "Llene todos los campos porfavor"
            }
        }
    }
