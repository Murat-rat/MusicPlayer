package com.example.musicplayer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.musicplayer.ui.components.ImagenPortada
import com.example.musicplayer.ui.components.ListaCanciones
import com.example.musicplayer.ui.components.TextoLabel
import com.example.musicplayer.ui.components.TextoTitulo
import com.example.musicplayer.viewmodel.MenuPrincipalViewModel
import com.example.musicplayer.R
import com.example.musicplayer.ui.components.BotonIconoCuadrado
import com.example.musicplayer.ui.components.BotonIconoRedondo
import com.example.musicplayer.ui.components.ControlReproduccion

@Composable
fun MenuScreen(viewModel: MenuPrincipalViewModel, navController: NavController){
    Column(modifier = Modifier
        .padding(top = 35.dp, bottom = 50.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(72.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 5.dp)
        ) {
            BotonIconoCuadrado(R.drawable.exit, 45, {navController.navigate("login")})
            TextoTitulo("Mis Canciones")
            //AQUI FALTA AGREGAR AL NAVIGATION
            BotonIconoRedondo(R.drawable.agregar, 45, { navController.navigate("agregarMusica") }, Color(40,66,245))
        }
        val cancion by viewModel.cancion.collectAsStateWithLifecycle()
        ListaCanciones (cancion) { navController.navigate("actual") }

        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 5.dp, end = 5.dp, top = 5.dp)
        ) {
            ImagenPortada(R.drawable.hamilton, 70)
            Column(modifier = Modifier.width(180.dp)) {
                TextoLabel(text = "Who Lives, Who Dies, Who Tells Your Story")
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
            }
            ControlReproduccion()
        }
    }
}