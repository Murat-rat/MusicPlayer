package com.example.musicplayer.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.musicplayer.ui.components.ListaCanciones
import com.example.musicplayer.ui.components.TextoLabel
import com.example.musicplayer.ui.components.TextoTitulo
import com.example.musicplayer.viewmodel.MenuPrincipalViewModel


@Composable
fun MenuScreen(viewModel: MenuPrincipalViewModel, navController: NavController){
    Column{
        TextoTitulo("Usuarios registrados")
        val cancion by viewModel.cancion.collectAsStateWithLifecycle()
        ListaCanciones (cancion) { viewModel::clickCancion }
        TextoLabel("Fin de la lista")
    }
}

