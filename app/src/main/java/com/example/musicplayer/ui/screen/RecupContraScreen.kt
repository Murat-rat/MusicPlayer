package com.example.musicplayer.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicplayer.ui.components.Button
import com.example.musicplayer.ui.components.InputField
import com.example.musicplayer.ui.components.TextoTitulo
import com.example.musicplayer.viewmodel.RecupContraViewModel

@Composable
fun RecupContraScreen(viewModel: RecupContraViewModel, navController: NavController) {
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
            viewModel = viewModel,
            label = "Correo"
        )

        InputField(
            viewModel = viewModel,
            label = "Nueva Contraseña"
        )

        InputField(
            viewModel = viewModel,
            label = "Confirmar Contraseña"
        )

        Button ("Aceptar") {
            viewModel.RecupContra {
                navController.navigate("recupcontra") {
                    popUpTo("login") { inclusive = true } // Evita volver al login
                }
            }
        }
    }
