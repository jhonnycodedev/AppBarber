package com.example.appbarber.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appbarber.components.MenuSuperior

@Composable
fun TelaSearchBarber(state: DrawerState, bottonNavBar: @Composable ()-> Unit) {
    Scaffold(
        //topBar = { MenuSuperior(state) },
        content = { iPad ->
            iPad

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Texto Olá, Jhonny no topo
                Text(
                    text = "Olá, Jhonny",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )

                // Caixa de Pesquisa
                val searchText = remember { mutableStateOf("") }
                TextField(
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    label = { Text("Pesquisar...") }, // Isso cuida do placeholder
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    }, // Ícone de pesquisa
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )


                // Botões de Classificação
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ClassificationButton("Nome", Icons.Default.Store)
                    ClassificationButton("Cidade", Icons.Default.LocationCity)
                    ClassificationButton("Próximos", Icons.Default.Place)
                }
            }

        },
        bottomBar = { bottonNavBar() }
    )
}

@Composable
fun ClassificationButton(text: String, icon: ImageVector) {
    Button(
        onClick = { /* TODO: Implementar ação */ },
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .width(120.dp)
            .height(50.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

