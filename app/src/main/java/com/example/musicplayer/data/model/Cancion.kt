package com.example.musicplayer.data.model

import androidx.annotation.DrawableRes

data class Cancion (
    val id:Int,
    val nombre: String,
    val album: String,
    val artista: String,
    val descripcion: String = "",
    @DrawableRes val image: Int

)