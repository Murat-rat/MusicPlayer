package com.example.musicplayer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.musicplayer.data.model.Cancion

@Dao
interface CancionDao {
    @Insert
    suspend fun insertarCancion(cancion: Cancion)

    @Query("SELECT * FROM canciones")
    suspend fun obtenerCanciones(): List<Cancion>

    @Update
    suspend fun actualizarCancion(cancion: Cancion)

    @Delete
    suspend fun delete(cancion: Cancion)
}