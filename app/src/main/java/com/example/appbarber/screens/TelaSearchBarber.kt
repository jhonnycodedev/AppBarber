package com.example.appbarber.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.R
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import com.example.appbarber.util.Barbearia


// Barbeiro agora implementa Identifiable
data class Barbeiro(
    override val name: String,
    override val location: String,
    override val imageResId: Int
) : Barbearia

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

    // Estados para a lista de barbeiros e o texto de pesquisa
    var barbeiros by remember { mutableStateOf(originalBarbeiros) }
    var searchText by remember { mutableStateOf("") }
    var selectedCity by remember { mutableStateOf<String?>(null) }

    // Função para filtrar barbeiros com base no texto de pesquisa e cidade selecionada
    fun filterBarbeiros() {
        barbeiros = originalBarbeiros.filter { barbeiro ->
            (searchText.isBlank() || barbeiro.name.contains(searchText, ignoreCase = true)) &&
                    (selectedCity == null || barbeiro.location == selectedCity)
        }
    }

    // Quando o texto de pesquisa ou a cidade selecionada mudarem, atualize a lista filtrada
    LaunchedEffect(searchText, selectedCity) {
        filterBarbeiros()
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
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
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

                // Dropdown de Cidades
                var expanded by remember { mutableStateOf(false) }
                val cidades = originalBarbeiros.map { it.location }.distinct()

                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { expanded = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.principal),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationCity,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = selectedCity ?: "Selecione a Cidade")
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        DropdownMenuItem(
                            text = { Text("Todas as Cidades") },
                            onClick = {
                                selectedCity = null
                                expanded = false
                            }
                        )
                        cidades.forEach { cidade ->
                            DropdownMenuItem(
                                text = { Text(cidade) },
                                onClick = {
                                    selectedCity = cidade
                                    expanded = false
                                }
                            )
                        }
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
fun MessageCard(barbeiro: Barbeiro) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Image(
            painter = painterResource(barbeiro.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
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

