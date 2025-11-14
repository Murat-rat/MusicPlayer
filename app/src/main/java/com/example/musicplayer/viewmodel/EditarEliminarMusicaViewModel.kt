package com.example.musicplayer.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.data.AppDatabase
import com.example.musicplayer.data.model.Cancion
import com.example.musicplayer.data.repository.CancionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditarEliminarMusicaViewModel(application: Application) : AndroidViewModel(application) {
    var archivo = mutableStateOf("Selecciona un music.mp3")
    var nombreCancion = mutableStateOf("")
    var artista = mutableStateOf("")
    var album = mutableStateOf("")
    var descripcion = mutableStateOf("")
    var imagen = mutableIntStateOf(0)

    private val repository: CancionRepository
    private var cancionId: Int? = null

    init {
        val dao = AppDatabase.getDatabase(application).cancionDao()
        repository = CancionRepository(dao)
    }

    fun cargarCancionPorId(id: Int) {
        cancionId = id
        viewModelScope.launch {
            val cancion = withContext(Dispatchers.IO) {
                repository.obtenerCancionPorId(id)
            }
            cancion?.let {
                nombreCancion.value = it.nombre
                artista.value = it.artista
                album.value = it.album
                descripcion.value = it.descripcion
                imagen.intValue = it.imagen
            }
        }
    }

    fun actualizar() {
        viewModelScope.launch(Dispatchers.IO) {
            cancionId?.let {
                val cancionActualizada = Cancion(
                    id = it,
                    nombre = nombreCancion.value,
                    artista = artista.value,
                    album = album.value,
                    descripcion = descripcion.value,
                    imagen = imagen.intValue
                )
                repository.actualizarCancion(cancionActualizada)
            }
        }
    }

    fun eliminar() {
        viewModelScope.launch(Dispatchers.IO) {
            cancionId?.let {
                val cancion = repository.obtenerCancionPorId(it)
                if (cancion != null) {
                    repository.eliminarCancion(cancion)
                }
            }
        }
    }
}