package com.example.appbarber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.components.TelaDetalhesBarbearia
import com.example.appbarber.screens.PrincipalPage
import com.example.appbarber.screens.TelaLogin
import com.example.appbarber.screens.TelaDeCadastro
import com.example.appbarber.util.originalBarbeiros
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa o Firebase
        FirebaseApp.initializeApp(this)

        // Define o conteúdo da atividade
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login" // Define a tela de login como ponto de partida
    ) {
        // Composable para TelaLogin
        composable("login") {
            TelaLogin(
                navController = navController,
                onLoginSuccess = {
                    navController.navigate("principal") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        // Composable para TelaCadastro
        composable("cadastro") {
            TelaDeCadastro(
                navController = navController, // Passa o navController para a TelaCadastro
                onRegisterSuccess = {
                    navController.navigate("login") {
                        popUpTo("cadastro") { inclusive = true }
                    }
                }
            )
        }

        // Composable para PrincipalPage (Tela principal após login)
        composable("principal") {
            PrincipalPage(
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("principal") { inclusive = true }
                    }
                }
            )
        }

        composable("detalhes/{barbeariaName}") { backStackEntry ->
            val barbeariaName = backStackEntry.arguments?.getString("barbeariaName")
            val barbearia = originalBarbeiros.find { it.name == barbeariaName }
            if (barbearia != null) {
                TelaDetalhesBarbearia(barbearia, navController)
            } else {
                // Caso não encontre a barbearia
                Text("Barbearia não encontrada")
            }
        }


    }
}

