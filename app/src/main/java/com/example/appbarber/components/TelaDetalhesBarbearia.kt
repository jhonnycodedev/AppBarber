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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.R
import com.example.appbarber.components.MenuSuperior

data class Servico(val nome: String, val preco: String)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaDetalhesBarbearia(barbearia: Barbearia, navController: NavController) {
    var isFavorito by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = { Text(barbearia.nome) }) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Logotipo maior
                Image(
                    painter = painterResource(id = barbearia.imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )

                // Botão de favoritos
                IconButton(onClick = {
                    isFavorito = !isFavorito
                    // Adicione lógica para gerenciar favoritos
                }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Icon(
                        imageVector = if (isFavorito) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorito) Color.Red else Color.Gray,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Lista de serviços
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

@Composable
fun ServicoItem(servico: Servico) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = servico.nome, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = servico.preco, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Agendar serviço */ }) {
                Text("Agendar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaDetalhesBarbearia() {
    TelaDetalhesBarbearia(
        barbearia = Barbearia("Barbearia Premium", "Centro", R.drawable.barbeiro1),
        navController = rememberNavController()
    )
}
