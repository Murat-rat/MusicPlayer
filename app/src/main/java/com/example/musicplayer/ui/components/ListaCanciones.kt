package com.example.musicplayer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.musicplayer.data.model.Cancion

@Composable
fun ListaCanciones(lista: List<Cancion>, x: (Cancion) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = lista, key = {it.id} ) {cancion ->
            CancionCard(cancion) { x(cancion) }
        }
    }
}