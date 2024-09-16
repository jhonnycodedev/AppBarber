package com.example.appbarber.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appbarber.components.MenuInferior
import com.example.appbarber.components.MenuSuperior

@Composable
fun TelaAgendamento(state: DrawerState, navController: NavController) {
    Scaffold(
        content = { innerPadding ->
            ConteudoDaPaginaAgendamento(Modifier.padding(innerPadding))
        },
        bottomBar = { MenuInferior(state, navController) }
    )
}

@Composable
fun ConteudoDaPaginaAgendamento(modifier: Modifier) {
    Column(
        modifier = modifier
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
        BasicTextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Color.Gray, MaterialTheme.shapes.medium)
                        .padding(8.dp)
                ) {
                    if (searchText.value.isEmpty()) {
                        Text(text = "Pesquisar...", color = Color.Gray)
                    }
                    innerTextField()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Botões de Classificação
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ClassificationButton("Nome", Icons.Default.Store)
            ClassificationButton("Cidade", Icons.Default.LocationCity)
            ClassificationButton("Próximos", Icons.Default.Place)
        }
    }
}
/*
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
*/