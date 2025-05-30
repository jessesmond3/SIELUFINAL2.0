package com.example.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.login.navigation.AppScreens // Import AppScreens to access your routes

@Composable
fun FraseScreen1(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "¡Hola desde la Pantalla Frase 1!")
        Button(
            onClick = {
                // Navigate to FraseScreen2 using its route
                navController.navigate(AppScreens.FraseScreen2.route)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Ir a Pantalla Frase 2")
        }
    }
}

@Composable
fun FraseScreen2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "¡Bienvenido a la Pantalla Frase 2!")
    }
}

// Optional: Previews for your screens
@Preview(showBackground = true)
@Composable
fun FraseScreen1Preview() {
    // For preview, you often need a dummy NavController
    val navController = rememberNavController()
    FraseScreen1(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun FraseScreen2Preview() {
    FraseScreen2()
}