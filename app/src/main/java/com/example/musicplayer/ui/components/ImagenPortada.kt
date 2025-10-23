package com.example.musicplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.musicplayer.data.model.Cancion

@Composable
fun ImagenPortada(
    c: Cancion
) {
    Image(
        painter = painterResource(c.image),
        contentDescription = "Portada de la canción"
    )
}