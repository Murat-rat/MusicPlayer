package com.example.musicplayer.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class AgregarMusicaViewModel: ViewModel() {
    var archivo = mutableStateOf("Selecciona un music.mp3")
    var nombreCancion = mutableStateOf("")
    var artista = mutableStateOf("")
    var album = mutableStateOf("")
    var descripcion = mutableStateOf("")

    fun guardar() {
        // Lógica de "Guardar" (por ahora, solo para demostración)
        println("Guardando canción: ${nombreCancion.value}")
    }
}