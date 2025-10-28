package com.example.musicplayer.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.R // Asegúrate de que este R.drawable.folder exista
import com.example.musicplayer.ui.components.BotonIconoCuadrado
import com.example.musicplayer.ui.components.InputField
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import com.example.musicplayer.viewmodel.AgregarMusicaViewModel
import com.example.musicplayer.viewmodel.EditarEliminarMusicaViewModel


@Composable
fun EditarEliminarMusicaScreen(
    viewModel: EditarEliminarMusicaViewModel = viewModel(),
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Fila superior: Botón de regreso
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BotonIconoCuadrado(R.drawable.regresar, 45, {navController.navigate("menu")})
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Placeholder para Imagen (El cuadrado con una X)
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, Color.Black)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "X", fontSize = 40.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Edita tus pistas", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(30.dp))

        // Campo para seleccionar el archivo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .border(BorderStroke(1.dp, Color.Gray))
                    .background(Color.LightGray.copy(alpha = 0.3f))
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = viewModel.archivo.value, color = Color.DarkGray)
            }
            IconButton(
                onClick = { /* Lógica para abrir selector de archivos */ },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                // Asumo que R.drawable.folder es el ícono de carpeta
                Icon(painterResource(R.drawable.folder), contentDescription = "Seleccionar Archivo")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campos de texto
        InputField(
            value = viewModel.nombreCancion.value,
            onValueChange = { viewModel.nombreCancion.value = it },
            label = "Ingresa nombre de la canción"
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputField(
            value = viewModel.artista.value,
            onValueChange = { viewModel.artista.value = it },
            label = "Artista (Opcional)"
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputField(
            value = viewModel.album.value,
            onValueChange = { viewModel.album.value = it },
            label = "Álbum (Opcional)"
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputField(
            value = viewModel.descripcion.value,
            onValueChange = { viewModel.descripcion.value = it },
            label = "Descripción (Opcional)",
            // Simular un campo de texto más grande
            //singleLine = false,
            //modifier = Modifier.height(100.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Botones Guardar y Eliminar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    viewModel.guardar2()
                    // Vuelve al MenuPrincipal
                    navController.popBackStack("menu", inclusive = false)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADD8E6)) // Azul claro
            ) {
                Text("Guardar", color = Color.Black)
            }

                        Button(
                            onClick = {
                                viewModel.eliminar2()
                                // Vuelve al MenuPrincipal
                                navController.popBackStack("menu", inclusive = false)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF08080)) // Rojo claro
                        ) {
                            Text("Eliminar", color = Color.Black)
                        }

        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewEditarEliminarMusicaScreen() {
    MusicPlayerTheme {
        val navController = rememberNavController()
        // Pasa un ViewModel de ejemplo al Preview
        val viewModel = AgregarMusicaViewModel()

        viewModel.nombreCancion.value = "Nombre de Canción Ejemplo"

        AgregarMusicaScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}