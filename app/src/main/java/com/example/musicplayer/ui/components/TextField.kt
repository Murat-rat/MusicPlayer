package com.example.musicplayer.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp


@Composable
fun TextField(
    texto: String
) {
    Text(
        text = texto,
        fontSize = 12.sp
    )
}
