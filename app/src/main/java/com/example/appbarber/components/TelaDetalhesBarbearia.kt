
package com.example.appbarber.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appbarber.data.Barbeiro

import com.example.appbarber.data.Servico


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun TelaDetalhesBarbearia (barbeiro: Barbeiro, navController: NavController) {

    var isFavorito by remember { mutableStateOf(false) }


    Scaffold(
        topBar = { TopAppBar(title = { Text(barbeiro.name) }) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = barbeiro.imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )

                IconButton(onClick = {
                    isFavorito = !isFavorito
                    // Lógica para gerenciar o estado favorito (local)
                }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Icon(
                        imageVector = if (isFavorito) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorito) Color.Red else Color.Gray,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Serviços da barbearia
                val servicos = listOf(
                    Servico("Corte de cabelo", "R$ 50,00"),
                    Servico("Barba", "R$ 30,00"),
                    Servico("Corte + Barba", "R$ 70,00")
                )

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(servicos) { servico ->
                        ServicoItem(servico)
                    }
                }
            }
        }
    )
}

