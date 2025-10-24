package com.example.musicplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicplayer.data.model.Cancion

@Composable
fun ImagenPortada(
    cancion: Cancion
) {
    Image(
        painter = painterResource(cancion.image),
        contentDescription = "Portada de la canción",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(45.dp)
    )
}