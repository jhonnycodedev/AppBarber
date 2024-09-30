package com.example.appbarber.screens

import com.example.appbarber.components.MessageCard
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appbarber.R
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.navigation.NavController
import com.example.appbarber.data.originalBarbeiros


@Composable
fun TelaSearchBarber(state: DrawerState, navController: NavController, bottonNavBar: @Composable () -> Unit) {

    val barbeiros = originalBarbeiros // Usando a lista do BarbeariasData.kt

    // Estados para a lista de barbeiros e o texto de pesquisa
    var filteredBarbeiros by remember { mutableStateOf(barbeiros) }
    var searchText by remember { mutableStateOf("") }
    var selectedCity by remember { mutableStateOf<String?>(null) }


    // Função para filtrar barbeiros
    fun filterBarbeiros() {
        filteredBarbeiros = barbeiros.filter { barbeiro ->
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
                    items(filteredBarbeiros) { barbeiro ->
                        MessageCard(barbeiro, navController) // Passando o navController
                    }
                }
            }
        },
        bottomBar = { bottonNavBar() }
    )
}


