package com.example.appbarber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.screens.PrincipalPage
import com.example.appbarber.screens.TelaLogin
import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            TelaLogin(onLoginSuccess = {
                // Navegar para a tela principal após o login
                navController.navigate("principal") {
                    // Opcional: Limpar a pilha de navegação para evitar voltar à tela de login
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("principal") {
            PrincipalPage(
                onLogout = {
                    // Navegar de volta para a tela de login e limpar a pilha de navegação
                    navController.navigate("login") {
                        popUpTo("principal") { inclusive = true }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppNavHost() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            AppNavHost()
        }
    }
}
