package com.example.musicplayer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.data.AppDatabase
import com.example.musicplayer.data.model.Cancion
import com.example.musicplayer.data.repository.CancionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

    class MenuPrincipalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CancionRepository
    val _cancion = MutableStateFlow<List<Cancion>>(emptyList())

    val cancion: StateFlow<List<Cancion>> = _cancion

    init {
        val database = AppDatabase.getDatabase(application)
        repository = CancionRepository(database.cancionDao())

        // Cargar canciones desde la base
        obtenerCanciones()
    }

    private fun obtenerCanciones() {
        viewModelScope.launch {
            val canciones = repository.obtenerCanciones()
            _cancion.value = canciones
        }
    }

    fun clickCancion(cancion: Cancion) {
        println("Has hecho click en: ${cancion.nombre}")
    }
}