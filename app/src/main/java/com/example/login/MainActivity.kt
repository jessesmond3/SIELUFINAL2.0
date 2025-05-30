package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Cargar layout XML
        setContentView(R.layout.activity_main)

        val loginXmlContainer = findViewById<View>(R.id.login_xml_container)
        val composeSplashContainer = findViewById<ComposeView>(R.id.compose_splash_container)

        // Mostrar splash, ocultar login
        loginXmlContainer.visibility = View.GONE

        composeSplashContainer.setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(
                        onSplashComplete = {
                            // Mostrar login y ocultar splash
                            runOnUiThread {
                                composeSplashContainer.visibility = View.GONE
                                loginXmlContainer.visibility = View.VISIBLE

                                val btn = findViewById<Button>(R.id.login_button)
                                btn.setOnClickListener {
                                    // Abrir la pantalla principal luego de login
                                    startActivity(Intent(this, PantallaPrincipalActivity::class.java))
                                    finish()
                                }
                            }
                        }
                    )
                }
            }
        }

        // Ajustar márgenes del sistema (status bar, nav bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
