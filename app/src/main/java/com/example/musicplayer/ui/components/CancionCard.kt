package com.example.musicplayer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicplayer.data.model.Cancion
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import com.example.musicplayer.R

@Composable
fun CancionCard(cancion: Cancion, x: (Cancion) -> Unit) {
    Card() {
        Row() {
            ImagenPortada(cancion)

            Column() {
                TextoSubtitulo(cancion.nombre)
                TextoLabel(cancion.artista)
                TextoLabel(cancion.album)
            }

            Button(
                onClick = {}
            ) {
                Text(text = "Editar", textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCancionCard(){
    val c = Cancion(
        1,
        "Yes I'm a Mess",
        "The Maybe Man",
        "AJR",
        "3ra canción del álbum",
        R.drawable.maybeman
    )
    MusicPlayerTheme {
        CancionCard (c) { }
    }
}