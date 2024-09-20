package com.example.appbarber.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.components.MenuSuperior


@Composable
fun TelaAgendamento(state: DrawerState, bottonNavBar: @Composable ()-> Unit){
    Scaffold(
        //topBar = { MenuSuperior(state) },
        content = { iPad -> iPad
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Tela Agendamento", fontSize = 50.sp)
            }
        },
        //floatingActionButton = { FloatingButton() },
        bottomBar = { bottonNavBar() }
    )
}



@Composable
fun FloatingButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "+",
            modifier = Modifier.size(40.dp)
        )
    }
}