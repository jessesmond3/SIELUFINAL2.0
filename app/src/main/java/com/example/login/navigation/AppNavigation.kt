package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.pantallaPrincipal // Ahora es un Composable de nivel superior
import com.example.login.splasScreen
import com.example.login.Inicio // Asumiendo que Inicio es ahora un Composable
import com.example.login.pantalladestino // Asumiendo que pantalladestino es un Composable
import com.example.login.FraseScreen1
import com.example.login.FraseScreen2


@Composable
fun AppNavigation(onSplashComplete: () -> Unit) { // Se eliminó el callback onSplashComplete
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.splasScreen.route
    ) {
        composable(AppScreens.splasScreen.route) {
            // splasScreen ahora navegará directamente a Inicio (Composable)
            splasScreen(navController = navController, onSplashComplete = onSplashComplete)
        }
        composable(AppScreens.Inicio.route) {
            Inicio() // Llama al composable de Inicio
        }
        composable(AppScreens.PantallaPrincipal.route) {
            pantallaPrincipal() // Llama al composable de pantallaPrincipal
        }
        composable(AppScreens.PantallaDestino.route) {
            pantalladestino() // Llama al composable de pantalladestino
        }
        composable(AppScreens.FraseScreen1.route) {
            FraseScreen1(navController = navController)
        }
        composable(AppScreens.FraseScreen2.route) {
            FraseScreen2()
        }
    }
}