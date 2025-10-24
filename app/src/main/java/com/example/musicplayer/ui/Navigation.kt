package com.example.musicplayer.ui

import androidx.compose.runtime.Composable
import com.example.musicplayer.viewmodel.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { ForgotPasswordScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("calculator") {
            val viewModel: CalculatorViewModel = viewModel() // instancia del ViewModel
            CalculatorScreen(viewModel = viewModel, navController = navController)
        }
        composable("tictactoe") {
            val viewModel: TicTacToeViewModel = viewModel() // instancia del ViewModel
            TicTacToeScreen(viewModel = viewModel, navController = navController)
        }
        composable("incubadora") {
            val viewModel: IncubadoraViewModel = viewModel() // instancia del ViewModel
            IncubadoraScreen(viewModel = viewModel, navController = navController)
        }
        composable("menu") {
            val viewModel: MenuViewModel = viewModel() // instancia del ViewModel
            MenuScreen(viewModel = viewModel, navController = navController)
        }
        composable("verUsuarios"){
            val viewModel: UserListViewModel = viewModel()
            UserScreen(viewModel, navController=navController)
        }
        composable("verLicencia"){
            val viewModel: LicenciaViewModel = viewModel()
            LicenciaScreen(viewModel, navController=navController)
        }
        //Nuevas rutas aca
    }
}