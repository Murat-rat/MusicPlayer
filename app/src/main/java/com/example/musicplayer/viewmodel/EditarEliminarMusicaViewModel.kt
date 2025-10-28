package com.example.musicplayer.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.musicplayer.R
import com.example.musicplayer.data.model.Cancion

class EditarEliminarMusicaViewModel: ViewModel() {
    var archivo = mutableStateOf("Selecciona un music.mp3")
    var nombreCancion = mutableStateOf("")
    var artista = mutableStateOf("")
    var album = mutableStateOf("")
    var descripcion = mutableStateOf("")

    fun guardar2() {
        // Lógica de "Guardar" (por ahora, solo para demostración)
        println("Guardando canción: ${nombreCancion.value}")
    }

    fun eliminar2() {
        // Lógica de "Eliminar" (por ahora, solo para demostración)
        println("Eliminando canción")
    }

}