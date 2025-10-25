package com.example.musicplayer.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.ui.screens.LoginScreen
import com.example.musicplayer.ui.screens.MenuScreen
import com.example.musicplayer.ui.screens.RecupContraScreen
import com.example.musicplayer.viewmodel.LoginViewModel
import com.example.musicplayer.viewmodel.MenuPrincipalViewModel
import com.example.musicplayer.viewmodel.RecupContraViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        //Nuevas rutas aca
        composable("menu") {
            val viewModel: MenuPrincipalViewModel = viewModel() // instancia del ViewModel
            MenuScreen(viewModel = viewModel, navController = navController)
        }

        composable("recuperar") {
            val viewModel: RecupContraViewModel = viewModel() // instancia del ViewModel
            RecupContraScreen(viewModel = viewModel, navController = navController)
        }
    }
}