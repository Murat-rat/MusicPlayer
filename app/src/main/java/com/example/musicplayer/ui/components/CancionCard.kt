package com.example.musicplayer.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicplayer.data.model.Cancion
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import com.example.musicplayer.R

@Composable
fun CancionCard(cancion: Cancion, onClick: () -> Unit, edit: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
        .clickable{ onClick() }
    ) {
        Row(modifier = Modifier
            .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ImagenPortada(cancion.image, 120)

            Column(modifier = Modifier.padding(top = 5.dp)) {
                TextoSubtitulo(cancion.nombre)
                TextoLabel(cancion.artista)
                TextoLabel(cancion.album)
                Button(
                    onClick = { edit() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(40,66,245))
                ) {
                    Text(text = "Editar", textAlign = TextAlign.Center)
                }
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
        CancionCard (c, { }, { })
    }
}