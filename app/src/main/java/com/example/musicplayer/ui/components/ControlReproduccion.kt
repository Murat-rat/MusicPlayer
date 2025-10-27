package com.example.musicplayer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.musicplayer.R

@Composable
fun ControlReproduccion() {
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        BotonIconoRedondo(R.drawable.rewind, 40,{})
        BotonIconoRedondo(R.drawable.pause, 40, {})
        BotonIconoRedondo(R.drawable.fastforward, 40, {})
    }
}