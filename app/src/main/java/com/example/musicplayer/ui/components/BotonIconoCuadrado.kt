package com.example.musicplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BotonIconoCuadrado(
    icono: Int,
    size: Int,
    onClick: () -> Unit,
    color: Color = Color.Gray,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(size.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = painterResource(icono),
            contentDescription = "Rewind",
            modifier = Modifier
                .size((size - 15).dp),
            contentScale = ContentScale.FillBounds
        )
    }
}