package com.example.musicplayer.ui.screen

import android.annotation.SuppressLint
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicplayer.ui.components.ImagenCircular
import com.example.musicplayer.ui.components.TextoTitulo
import com.example.musicplayer.R
import com.example.musicplayer.ui.components.Button
import com.example.musicplayer.ui.components.InputField
import com.example.musicplayer.ui.components.Link
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import com.example.musicplayer.viewmodel.LoginViewModel


@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        ImagenCircular(R.drawable.music)
        TextoTitulo("Aplicación\nMóvil")

        InputField(
            viewModel = viewModel,
            label = "Usuario"
        )

        InputField(
            viewModel = viewModel,
            label = "Contraseña"
        )

        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Link("¿Olvidaste tu contraseña?") {
            navController.navigate("forgot_password")
        }

        Button ("Iniciar sesión") {
            viewModel.login {
                navController.navigate("calculator") {
                    popUpTo("login") { inclusive = true } // Evita volver al login
                }
            }
        }

        Link ("¿No tienes cuenta? Regístrate") {
            navController.navigate("register")
        }

    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MusicPlayerTheme {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()

        LoginScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}
