package com.example.appbarber.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.appbarber.components.BarbeariaItem
import com.example.appbarber.components.MenuSuperior
import com.example.appbarber.data.Barbeiro


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaFavoritos(state: DrawerState) {
    val barbeariasFavoritas = remember { mutableStateListOf<Barbeiro>() }

    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { p -> ConteudoTelaFavoritos(Modifier.padding(p), barbeariasFavoritas) }
    )
}

@Composable
fun ConteudoTelaFavoritos(modifier: Modifier, barbeariasFavoritas: SnapshotStateList<Barbeiro>) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Barbearias Favoritas", fontSize = 32.sp, modifier = Modifier.padding(bottom = 16.dp))

        if (barbeariasFavoritas.isEmpty()) {
            Text("Nenhuma barbearia favoritada ainda!")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(barbeariasFavoritas) { Barbeiro ->
                    BarbeariaItem(Barbeiro) { /* Ação de favoritar */ }
                }
            }
        }
    }
}
