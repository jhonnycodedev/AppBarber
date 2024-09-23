package com.example.appbarber.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.R
import com.example.appbarber.components.MenuSuperior

data class Barbearia(val nome: String, val localizacao: String, val imageResId: Int)

@Composable
fun TelaFavoritos(state: DrawerState) {
    // Estado para armazenar as barbearias favoritas
    val barbeariasFavoritas = remember { mutableStateListOf<Barbearia>() }

    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { p -> ConteudoTelaFavoritos(Modifier.padding(p), barbeariasFavoritas) }
    )
}

@Composable
fun ConteudoTelaFavoritos(modifier: Modifier, barbeariasFavoritas: SnapshotStateList<Barbearia>) {
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
                items(barbeariasFavoritas) { barbearia ->
                    BarbeariaItem(barbearia, barbeariasFavoritas)
                }
            }
        }
    }
}

@Composable
fun BarbeariaItem(barbearia: Barbearia, barbeariasFavoritas: SnapshotStateList<Barbearia>) {
    var isFavorito by remember { mutableStateOf(true) } // Assume que está favoritado para preview

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagem da barbearia
        Image(
            painter = painterResource(barbearia.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Informações da barbearia
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = barbearia.nome, fontSize = 20.sp, color = Color.Black)
            Text(text = barbearia.localizacao, fontSize = 16.sp, color = Color.Gray)
        }

        // Botão de favoritos
        IconButton(onClick = {
            if (isFavorito) {
                barbeariasFavoritas.remove(barbearia)
            } else {
                barbeariasFavoritas.add(barbearia)
            }
            isFavorito = !isFavorito
        }) {
            Icon(
                imageVector = if (isFavorito) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = null,
                tint = if (isFavorito) Color.Red else Color.Gray,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun PreviewTelaFavoritos() {
    val barbeariasFavoritas = mutableStateListOf(
        Barbearia("Barbearia Premium", "Centro", R.drawable.barbeiro1),
        Barbearia("Navalha de Ouro", "Batel", R.drawable.logo1)
    )

    TelaFavoritos(state = DrawerState(DrawerValue.Closed))
}
