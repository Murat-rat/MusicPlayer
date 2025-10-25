package com.example.musicplayer.viewmodel

import com.example.musicplayer.R
import com.example.musicplayer.data.model.Cancion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MenuPrincipalViewModel {
    val _cancion = MutableStateFlow<List<Cancion>>(emptyList())

    val cancion: StateFlow<List<Cancion>> = _cancion

    init {
        _cancion.value = listOf(
            Cancion(1, "Yes I'm a Mess", "The Maybe Man", "AJR", "3ra canción del álbum", R.drawable.maybeman)
        )
    }

    fun clickCancion(cancion: Cancion) {
        println("Has hecho click en: ${cancion.nombre}")
    }
}