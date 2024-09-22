package com.example.appbarber.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appbarber.components.BarberBottomBar
import com.example.appbarber.components.MenuInferior
import com.example.appbarber.components.MenuSuperior


@Composable
fun TelaMeusAcessos(state: DrawerState){
    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { p -> ConteudoMeusAcessos(Modifier.padding(p)) },
        //floatingActionButton = { FloatingButton() },

    )
}

@Composable
fun ConteudoMeusAcessos(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(), // Use o modifier passado como parâmetro
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela Meus Acessos", fontSize = 50.sp)
    }
}