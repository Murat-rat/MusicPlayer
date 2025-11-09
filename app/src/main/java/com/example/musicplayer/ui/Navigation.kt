package com.example.musicplayer.ui

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.ui.screens.AgregarMusicaScreen
import com.example.musicplayer.ui.screens.CancionActualScreen
import com.example.musicplayer.ui.screens.EditarEliminarMusicaScreen
import com.example.musicplayer.ui.screens.LoginScreen
import com.example.musicplayer.ui.screens.MenuScreen
import com.example.musicplayer.ui.screens.RecupContraScreen
import com.example.musicplayer.ui.screens.RegistrarScreen
import com.example.musicplayer.viewmodel.AgregarMusicaViewModel
import com.example.musicplayer.viewmodel.CancionActualViewModel
import com.example.musicplayer.viewmodel.EditarEliminarMusicaViewModel
import com.example.musicplayer.viewmodel.LoginViewModel
import com.example.musicplayer.viewmodel.MenuPrincipalViewModel
import com.example.musicplayer.viewmodel.RecupContraViewModel
import com.example.musicplayer.viewmodel.RegistrarViewModel

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
            val context = LocalContext.current
            val viewModel: MenuPrincipalViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
            )
            MenuScreen(viewModel = viewModel, navController = navController)
        }

        composable("recuperar") {
            val viewModel: RecupContraViewModel = viewModel()
            RecupContraScreen(viewModel = viewModel, navController = navController)
        }

        composable("actual") {
            val viewModel: CancionActualViewModel = viewModel()
            CancionActualScreen(viewModel = viewModel, navController = navController)
        }

        composable("register") {
            val viewModel: RegistrarViewModel = viewModel()
            RegistrarScreen(viewModel = viewModel, navController = navController)
        }

        composable("agregarMusica") {
            val viewModel: AgregarMusicaViewModel = viewModel()
            AgregarMusicaScreen(viewModel = viewModel, navController = navController)
        }

        composable("editarMusica") {
            val viewModel: EditarEliminarMusicaViewModel = viewModel()
            EditarEliminarMusicaScreen(viewModel = viewModel, navController = navController)
        }
    }
}