package com.example.musicplayer.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.data.AppDatabase
import com.example.musicplayer.data.model.Cancion
import com.example.musicplayer.data.repository.CancionRepository
import kotlinx.coroutines.launch

class AgregarMusicaViewModel(application: Application) : AndroidViewModel(application) {
    var archivo = mutableStateOf("Selecciona un archivo.mp3")
    var nombreCancion = mutableStateOf("")
    var artista = mutableStateOf("")
    var album = mutableStateOf("")
    var descripcion = mutableStateOf("")
    var imagen = mutableIntStateOf(0)

    private val repository: CancionRepository

    init {
        val dao = AppDatabase.getDatabase(application).cancionDao()
        repository = CancionRepository(dao)
    }

    fun guardar() {
        val nuevaCancion = Cancion(
            nombre = nombreCancion.value,
            artista = artista.value,
            album = album.value,
            descripcion = descripcion.value,
            imagen = imagen.intValue
        )

        viewModelScope.launch {
            repository.insertarCancion(nuevaCancion)
        }
    }
}
