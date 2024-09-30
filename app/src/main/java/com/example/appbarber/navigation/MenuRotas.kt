package com.example.appbarber.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.components.MenuInferior
import com.example.appbarber.screens.TelaInicio
import com.example.appbarber.screens.TelaSearchBarber
import com.example.appbarber.screens.TelaAgendamento
import com.example.appbarber.screens.TelaLogin
import com.example.appbarber.screens.TelaCadastro

@Composable
fun MenuRotas(state: DrawerState) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TelaRotasBottom.TelaInicio
    ) {
        composable(TelaRotasBottom.TelaInicio) {
            TelaInicio(state) { MenuInferior(navController) }
        }
        composable(TelaRotasBottom.TelaSearchBarber) {
            TelaSearchBarber(state, navController) { MenuInferior(navController) }
        }
        composable(TelaRotasBottom.TelaAgendamento) {
            TelaAgendamento(state) { MenuInferior(navController) }
        }
        // Nova rota para Tela de Login
        composable(TelaRotasBottom.TelaLogin) {
            TelaLogin(navController = navController) { /* Lógica para login bem-sucedido */ }
        }
        // Nova rota para Tela de Cadastro
        composable(TelaRotasBottom.TelaCadastro) {
            TelaCadastro(navController = navController) { /* Lógica para registro bem-sucedido */ }
        }
    }
}
