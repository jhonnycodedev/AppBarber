package com.example.appbarber.screens


import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun TelaMenuA(modifier: Modifier) {
    Scaffold(
            content = { p -> ConteudoDaPaginaMenuA(modifier.padding(p)) },
    )
}

@Composable
fun ConteudoDaPaginaMenuA(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(), // Use o modifier passado como parâmetro
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela Menu A", fontSize = 50.sp)
    }
}

