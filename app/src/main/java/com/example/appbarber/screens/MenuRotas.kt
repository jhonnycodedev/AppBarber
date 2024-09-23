package com.example.appbarber.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.components.MenuInferior

object TelaRotasBottom {
    val TelaInicio = "inicio"
    val TelaSearchBarber = "pesquisa"
    val TelaAgendamento = "agendamento"
}


@Composable
fun MenuRotas(state: DrawerState) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TelaRotasBottom.TelaInicio

    ) {
        composable(TelaRotasBottom.TelaInicio) {
            TelaInicio(state, { MenuInferior(navController) })
        }
        composable(TelaRotasBottom.TelaSearchBarber) {
            TelaSearchBarber(state) { MenuInferior(navController) }
        }
        composable(TelaRotasBottom.TelaAgendamento) {
            TelaAgendamento(state, { MenuInferior(navController)})
        }
    }
}

