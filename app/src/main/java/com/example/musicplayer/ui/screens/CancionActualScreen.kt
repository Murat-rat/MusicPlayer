package com.example.musicplayer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musicplayer.R
import com.example.musicplayer.ui.components.BotonIconoCuadrado
import com.example.musicplayer.ui.components.ControlReproduccion
import com.example.musicplayer.ui.components.ImagenPortada
import com.example.musicplayer.ui.components.TextoLabel
import com.example.musicplayer.ui.components.TextoSubtitulo
import com.example.musicplayer.ui.components.TextoTitulo
import com.example.musicplayer.viewmodel.CancionActualViewModel

@Composable
fun CancionActualScreen(viewModel: CancionActualViewModel, navController: NavController){
    val cancion = viewModel.cancion
    Column(
        modifier = Modifier
            .padding(top = 55.dp, start = 20.dp, end = 20.dp)
    ) {
        BotonIconoCuadrado(R.drawable.regresar, 45, {navController.navigate("menu")})
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(top = 50.dp)
        ) {
            ImagenPortada(cancion.imagen, 200)
            TextoTitulo(cancion.nombre)
            TextoSubtitulo(cancion.artista)
            TextoSubtitulo(cancion.album)
            TextoLabel(cancion.descripcion)
            var sliderPosition by remember { mutableFloatStateOf(0f) }
            Slider(
                value = sliderPosition,
                onValueChange = {sliderPosition = it},
                colors = SliderDefaults.colors(
                    thumbColor = Color(40,66,245),
                    activeTrackColor = Color(40,66,245),
                    inactiveTrackColor = Color.Gray
                ),
                modifier = Modifier.height(30.dp)
            )
            ControlReproduccion()
        }
    }
}