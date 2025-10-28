package com.example.musicplayer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.musicplayer.viewmodel.RegistrarViewModel

@Composable
fun RegistrarScreen(viewModel: RegistrarViewModel, navController: NavController) {
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
        TextoTitulo("Registrarse")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button("Inicio de sesión")  {
                    navController.navigate("login")
            }

            Button("Regístrate") {
                navController.navigate("register")
            }
        }

        InputField(
            value = viewModel.nombre.value,
            onValueChange = { viewModel.nombre.value = it },
            label = "Nombre"
        )

        InputField(
            value = viewModel.apellido.value,
            onValueChange = { viewModel.apellido.value = it },
            label = "Apellido"
        )

        InputField(
            value = viewModel.telefono.value,
            onValueChange = { viewModel.telefono.value = it },
            label = "Telefono"
        )

        InputField(
            value = viewModel.correo.value,
            onValueChange = { viewModel.correo.value = it },
            label = "Correo"
        )

        InputField(
            value = viewModel.contra.value,
            onValueChange = { viewModel.contra.value = it },
            label = "Contraseña"
        )

        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Button("Aceptar") {
            viewModel.registrar {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true } // Evita volver al login*
                }
            }
        }
    }
}