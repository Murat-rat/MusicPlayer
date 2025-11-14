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
import java.io.File

class AgregarMusicaViewModel(application: Application) : AndroidViewModel(application) {

    var archivo = mutableStateOf("Selecciona un archivo.mp3")
    var nombreCancion = mutableStateOf("")
    var artista = mutableStateOf("")
    var album = mutableStateOf("")
    var descripcion = mutableStateOf("")
    var imagen = mutableIntStateOf(0)

    // 🔹 Aquí la variable que te faltaba
    var imagenFile: File? = null

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

            // Guardado local
            repository.insertarCancion(nuevaCancion)

            // Guardado remoto
            try {
                println(nombreCancion.value)
                println(album.value)
                println(artista.value)
                println(descripcion.value)
                println(imagenFile==null)
                val response = repository.insertarCancionRemota(
                    nombre = nombreCancion.value,
                    album = album.value,
                    artista = artista.value,
                    descripcion = descripcion.value,
                    imagenFile = imagenFile
                )

                if (response.isSuccessful) {
                    println("Canción enviada correctamente al servidor.")
                } else {
                    println("Error al enviar canción: ${response.code()}")
                }

            } catch (e: Exception) {
                println("Error de red: ${e.localizedMessage}")
                println(e)
            }
        }
    }
}