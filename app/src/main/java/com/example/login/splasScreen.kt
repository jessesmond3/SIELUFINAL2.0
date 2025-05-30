package com.example.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun splasScreen(navController: NavHostController, onSplashComplete: () -> Unit){
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack() // Elimina el splash de la pila de retroceso
        navController.navigate(AppScreens.Inicio.route) // Navega directamente a Inicio

        onSplashComplete()
    }
    Splash()
}

@Composable
fun Splash(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(R.drawable.logo), // Asumiendo que R.drawable.logosplash existe
            contentDescription = "Logo Splash",
            Modifier.size(200.dp, 200.dp)) // Un tamaño más razonable
    }
}