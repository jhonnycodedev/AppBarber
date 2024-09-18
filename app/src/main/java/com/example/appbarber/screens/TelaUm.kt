package com.example.appbarber.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.components.BarberBottomBar
import com.example.appbarber.components.MenuInferior
import com.example.appbarber.components.MenuSuperior

object TelaRotasBottom {
    val TelaMenuA = "inicio"
    val TelaMenuB = "pesquisa"
    val TelaMenuC = "agendamento"
}


@Composable
fun TelaUm(state: DrawerState) {
    val navController = rememberNavController()


    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { p ->
            NavHost(
                navController = navController,
                startDestination = TelaRotasBottom.TelaMenuA
            ) {
                composable(TelaRotasBottom.TelaMenuA) {
                    TelaMenuA(Modifier.padding(p))
                }
                composable(TelaRotasBottom.TelaMenuB) {
                    TelaMenuB(Modifier.padding(p))
                }
                composable(TelaRotasBottom.TelaMenuC) {
                    TelaMenuC(Modifier.padding(p))
                }
            }
        },
        bottomBar = { MenuInferior(navController) }
    )
}
