package com.example.login.navigation

sealed class AppScreens(val route: String) {
    object splasScreen : AppScreens("splash_screen")
    object Inicio : AppScreens("inicio_screen")
    object PantallaPrincipal : AppScreens("pantalla_principal_screen")
    object PantallaDestino : AppScreens("pantalla_destino_screen")
    object FraseScreen1 : AppScreens("frase_screen1")
    object FraseScreen2 : AppScreens("frase_screen2")
}