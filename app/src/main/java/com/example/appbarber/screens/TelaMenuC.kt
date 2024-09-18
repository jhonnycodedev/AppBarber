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


@Composable
fun TelaMenuC(modifier: Modifier) {
    Scaffold(
        content = { p -> ConteudoDaPaginaMenuC(modifier.padding(p)) },
        floatingActionButton = { FloatingButton(onClick = { /* Ação */ }) }
    )
}

@Composable
fun ConteudoDaPaginaMenuC(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(), // Use o modifier passado como parâmetro
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela Menu C", fontSize = 50.sp)
    }
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