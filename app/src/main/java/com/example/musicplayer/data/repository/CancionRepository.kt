package com.example.musicplayer.data.repository

import com.example.musicplayer.data.CancionDao
import com.example.musicplayer.data.model.Cancion
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import java.io.File

class CancionRepository(private val cancionDao: CancionDao) {
    fun obtenerCanciones(): Flow<List<Cancion>> {
        return cancionDao.obtenerCanciones()
    }

    suspend fun obtenerCancionPorId(id: Int): Cancion? {
        return cancionDao.obtenerCancionPorId(id)
    }

    suspend fun insertarCancion(cancion: Cancion) {
        cancionDao.insertarCancion(cancion)
    }

    suspend fun actualizarCancion(cancion: Cancion) {
        cancionDao.actualizarCancion(cancion)
    }

    suspend fun eliminarCancion(cancion: Cancion) {
        cancionDao.delete(cancion)
    }

    suspend fun obtenerCancionesRemotas(): Response<List<Cancion>> {
        return RetrofitInstance.api.getCanciones()
    }

    suspend fun insertarCancionRemota(
        nombre: String,
        album: String,
        artista: String,
        descripcion: String,
        imagenFile: File? = null
    ): Response<Cancion> {
        val nombrePart = RequestBody.create("text/plain".toMediaTypeOrNull(), nombre)
        val albumPart = RequestBody.create("text/plain".toMediaTypeOrNull(), album)
        val artistaPart = RequestBody.create("text/plain".toMediaTypeOrNull(), artista)
        val descripcionPart = RequestBody.create("text/plain".toMediaTypeOrNull(), descripcion)

        val imagenPart = imagenFile?.let {
            val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), it)
            MultipartBody.Part.createFormData("imagen", it.name, requestFile)
        }

        return RetrofitInstance.api.createCancion(
            nombrePart,
            albumPart,
            artistaPart,
            descripcionPart,
            imagenPart
        )
    }

    suspend fun eliminarCancionRemota(id: Int): Response<Void> {
        return RetrofitInstance.api.deleteCancion(id)
    }
}
