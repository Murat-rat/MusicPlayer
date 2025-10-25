package com.example.musicplayer.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.musicplayer.viewmodel.RecupContraViewModel


@Composable
fun TextField(
    viewModel: RecupContraViewModel,
    label: String = "Usuario",
    onNext: (() -> Unit)? = null,
    texto: String
) {
    Text(
        text = texto,
        fontSize = 12.sp
    )
}
