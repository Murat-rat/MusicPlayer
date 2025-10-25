package com.example.musicplayer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicplayer.R
import com.example.musicplayer.data.model.Cancion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MenuPrincipalViewModel: ViewModel() {
    val _cancion = MutableStateFlow<List<Cancion>>(emptyList())

    val cancion: StateFlow<List<Cancion>> = _cancion

    init {
        _cancion.value = listOf(
            Cancion(1, "Yes I'm a Mess", "The Maybe Man", "AJR", "3ra canción del álbum", R.drawable.maybeman),
            Cancion(2, "Satisfied", "Hamilton", "Lin Manuel Miranda", "He will never be satisfied", R.drawable.hamilton),
            Cancion(3, "Karma", "Neotheater", "AJR", "If only I could keep you in my pocket...", R.drawable.neotheater),
            Cancion(4, "Touchy Feely Fool", "The Maybe Man", "AJR", "2da canción del álbum", R.drawable.maybeman),
            Cancion(5, "Alexander Hamilton", "Hamilton", "Lin Manuel Miranda", "How does a bastard, orphan, son of a whore and a soctsman grows up to be a hero and a scholar?", R.drawable.hamilton),
            Cancion(6, "Next Up Forever", "Neotheater", "AJR", "Welcome to the Neotheater", R.drawable.neotheater),
            Cancion(7, "I Won't", "The Maybe Man", "AJR", "I must've missed the hype...", R.drawable.maybeman),
            Cancion(8, "Non Stop", "Hamilton", "Lin Manuel Miranda", "Why do you write like you're running out of time?", R.drawable.hamilton),
            Cancion(9, "Finale (Can't Wait To See What You'll Do Next)", "Neotheater", "AJR", "I think my curtain's fallin'", R.drawable.neotheater),
            )
    }

    fun clickCancion(cancion: Cancion) {
        println("Has hecho click en: ${cancion.nombre}")
    }
}