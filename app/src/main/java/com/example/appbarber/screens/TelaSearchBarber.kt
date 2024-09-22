package com.example.appbarber.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.R

// Dados do Barbeiro
data class Barbeiro(val name: String, val location: String, val imageResId: Int)

@Composable
fun TelaSearchBarber(state: DrawerState, bottonNavBar: @Composable () -> Unit) {
    // Lista de Barbeiros para pré-exibir
    val originalBarbeiros = listOf(
        Barbeiro("Barbeiro chique no ultimo", "Batel", R.drawable.barbeiro1),
        Barbeiro("Deuses da Navalha", "Colombo", R.drawable.logo1),
        Barbeiro("Barbearia do Zé", "Piraquara", R.drawable.logo2),
        Barbeiro("Corte & Cia", "Bairro Alto", R.drawable.logo4),
        Barbeiro("Corte & Barba", "Pinhais", R.drawable.semfoto),
        Barbeiro("Ai q gatuu..", "Tatuquara", R.drawable.logo5)
    )

    // Estado para a lista de barbeiros ordenada
    var barbeiros by remember { mutableStateOf(originalBarbeiros) }

    // Estado para controle de ordenação
    var sortByLocation by remember { mutableStateOf(false) }

    // Função para ordenar barbeiros
    fun sortBarbeiros() {
        barbeiros = if (sortByLocation) {
            originalBarbeiros.sortedBy { it.location } // Ordena por localização
        } else {
            originalBarbeiros // Retorna à ordem original
        }
    }

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Texto "Olá, Jhonny" no topo
                Text(
                    text = "Olá, Jhonny",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )

                // Caixa de Pesquisa arredondada
                val searchText = remember { mutableStateOf("") }
                TextField(
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    label = { Text("Pesquisar...") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .border(1.dp, Color.Gray, CircleShape)
                        .clip(CircleShape)
                )

                // Botões de Classificação
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    //ClassificationButton("Nome", Icons.Default.Store) {
                        //barbeiros = originalBarbeiros // Ordena por nome (padrão)
                    //}
                    ClassificationButton("Cidade", Icons.Default.LocationCity) {
                        sortByLocation = !sortByLocation
                        sortBarbeiros()
                    }
                }

                // Lista de Barbeiros
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(barbeiros) { barbeiro ->
                        MessageCard(barbeiro)
                    }
                }
            }
        },
        bottomBar = { bottonNavBar() }
    )
}

@Composable
fun ClassificationButton(text: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.principal),
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(120.dp)
            .height(50.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

@Composable
fun MessageCard(barbeiro: Barbeiro) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Image(
            painter = painterResource(barbeiro.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp) // Aumentei o tamanho para destaque
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = barbeiro.name, fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = barbeiro.location, fontSize = 16.sp,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaSearchBarber() {
    TelaSearchBarber(state = DrawerState(DrawerValue.Closed), bottonNavBar = { /* Empty content */ })
}
