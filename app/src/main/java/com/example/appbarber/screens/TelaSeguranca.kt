package com.example.appbarber.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.components.BarberBottomBar
import com.example.appbarber.components.MenuInferior
import com.example.appbarber.components.MenuSuperior

@Composable
fun TelaSeguranca(state: DrawerState) {
    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { p -> ConteudoTelaSeguranca(Modifier.padding(p)) },

    )
}


@Composable
fun ConteudoTelaSeguranca(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela Seguranca", fontSize = 50.sp)
    }
}
