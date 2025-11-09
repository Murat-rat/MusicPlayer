package com.example.musicplayer.data.repository

import com.example.musicplayer.data.CancionDao
import com.example.musicplayer.data.model.Cancion

class CancionRepository(private val cancionDao: CancionDao) {
    suspend fun obtenerCanciones(): List<Cancion> {
        return cancionDao.obtenerCanciones()
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
}
