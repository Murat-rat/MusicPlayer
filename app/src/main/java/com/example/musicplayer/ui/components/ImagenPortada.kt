package com.example.musicplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicplayer.R

@Composable
fun ImagenPortada(
    portada: Int,
    size: Int
) {
    Image(
        painter = painterResource(if(portada != 0) portada else R.drawable.hamilton),
        contentDescription = "Portada de la canción",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(10))
    )
}