package com.example.musicplayer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musicplayer.R
import com.example.musicplayer.ui.components.BotonIconoCuadrado
import com.example.musicplayer.ui.components.Button
import com.example.musicplayer.ui.components.InputField
import com.example.musicplayer.ui.components.TextoTitulo
import com.example.musicplayer.viewmodel.RecupContraViewModel

@Composable
fun RecupContraScreen(viewModel: RecupContraViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(top = 55.dp, start = 20.dp)
    ) {
        BotonIconoCuadrado(R.drawable.regresar, 45, {navController.navigate("login")})
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        TextoTitulo("Recuperar Contraseña")

        InputField(
            value = viewModel.correo.value,
            onValueChange = { viewModel.correo.value = it },
            label = "Correo"
        )

        InputField(
            value = viewModel.nuevacontra.value,
            onValueChange = { viewModel.nuevacontra.value = it },
            label = "Nueva Contraseña"
        )

        InputField(
            value = viewModel.confirmarcontra.value,
            onValueChange = { viewModel.confirmarcontra.value = it },
            label = "Confirmar Contraseña"
        )

        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Button("Aceptar") {
            viewModel.recupContra {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true } // Evita volver al login
                }
            }
        }
    }
}