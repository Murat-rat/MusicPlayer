package com.example.musicplayer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicplayer.R
import com.example.musicplayer.data.model.Cancion
import com.example.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun ListaCanciones(lista: List<Cancion>, onClick: () -> Unit, edit: (Int) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.height(700.dp)
    ) {
        items(items = lista, key = {it.id} ) {cancion ->
            CancionCard(cancion,  { onClick() }, { edit(cancion.id) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListaCanciones(){
    val lista = listOf(
        Cancion(1, "Yes I'm a Mess", "The Maybe Man", "AJR", "3ra canción del álbum", R.drawable.maybeman),
        Cancion(2, "Satisfied", "Hamilton", "Lin Manuel Miranda", "He will never be satisfied", R.drawable.hamilton),
        Cancion(3, "Karma", "Neotheater", "AJR", "If only I could keep you in my pocket...", R.drawable.neotheater),
    )
    MusicPlayerTheme {
        ListaCanciones(lista, { }, { })
    }
}