package com.example.musicplayer.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun TextoTitulo(
    texto: String
) {
    Text(
        text = texto,
        fontSize = 24.sp
    )
}