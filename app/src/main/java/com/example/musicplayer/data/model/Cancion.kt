package com.example.musicplayer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "canciones")
data class Cancion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "album") val album: String,
    @ColumnInfo(name = "artista") val artista: String,
    @ColumnInfo(name = "descripcion") val descripcion: String = "",
    @ColumnInfo(name = "imagen") val imagen: Int
)