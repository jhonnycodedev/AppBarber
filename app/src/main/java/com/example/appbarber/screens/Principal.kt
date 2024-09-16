package com.example.appbarber.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.appbarber.components.AbaLateral
import com.example.appbarber.components.MenuInferior
import com.example.appbarber.components.MenuSuperior
import kotlinx.coroutines.CoroutineScope

object BarberAppRotas {
    const val TELA_UM = "um"
    const val TELA_DOIS = "dois"
    const val TELA_TRES = "tres"
    const val TELA_QUATRO = "quatro"
    const val TELA_CONTA = "conta"
}

@Preview
@Composable
fun PrincipalPage() {
    val state = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: BarberAppRotas.TELA_UM

    ModalNavigationDrawer(
        drawerState = state,
        drawerContent = { AbaLateral(navController, state, rotaAtual, coroutineScope) },
        content = {
            NavHost(navController = navController, startDestination = BarberAppRotas.TELA_UM) {
                composable(BarberAppRotas.TELA_UM) { TelaUm(state, navController) }
                composable(BarberAppRotas.TELA_DOIS) { TelaDois(state, navController) }
                composable(BarberAppRotas.TELA_TRES) { TelaTres(state, navController) }
                composable(BarberAppRotas.TELA_CONTA) { TelaConta(state, navController) }
                composable(BarberAppRotas.TELA_QUATRO) { TelaQuatro(state, navController) }

            }
        }
    )
}

@Composable
fun TelaPrincipal(state: DrawerState, navController: NavController, coroutineScope: CoroutineScope) {
    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { p -> ConteudoDaPagina(Modifier.padding(p)) },
        bottomBar = { MenuInferior(state, navController) }
    )
}



@Composable
fun ConteudoDaPagina(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Conteúdo...", fontSize = 50.sp)
    }
}




