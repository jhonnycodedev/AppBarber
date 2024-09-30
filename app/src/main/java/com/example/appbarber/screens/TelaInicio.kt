package com.example.appbarber.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.R
import com.example.appbarber.components.MenuSuperior
import com.example.appbarber.data.Servico

@Composable
fun TelaInicio(state: DrawerState, bottonNavBar: @Composable () -> Unit) {
    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Seção de Propagandas
                SectionPropagandas(modifier = Modifier.weight(1f))

                Spacer(modifier = Modifier.height(16.dp))

                // Seção Últimos Serviços Acessados
                SectionUltimosServicos(modifier = Modifier.weight(1f))
            }
        },
        bottomBar = { bottonNavBar() }
    )
}

@Composable
fun SectionPropagandas(modifier: Modifier = Modifier) {
    // Imagem de propaganda
    val propagandaImage: Painter = painterResource(id = R.drawable.propaganda)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = propagandaImage,
            contentDescription = "Imagem de Propaganda",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp) // Define uma altura mínima
                .clip(RoundedCornerShape(8.dp)), // Adiciona cantos arredondados se desejar
            contentScale = ContentScale.Crop // Ajusta a imagem para preencher a Box
        )
    }
}

@Composable
fun SectionUltimosServicos(modifier: Modifier = Modifier) {
    // Simulação de uma lista de últimos serviços acessados
    val servicosRecentes = listOf(
        Servico("Corte de Cabelo", 50.0.toString(), R.drawable.logo2),
        Servico("Barba e Cabelo", 70.0.toString(), R.drawable.logo2),
        Servico("Sombrancelha", 30.0.toString(), R.drawable.logo2)
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Últimos Serviços Acessados",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Exibição dos serviços acessados
        servicosRecentes.forEach { servico ->
            UltimoServicoItem(servico = servico)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun UltimoServicoItem(servico: Servico) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagem do serviço
        servico.imageResId?.let { painterResource(it) }?.let {
            Image(
                painter = it,
                contentDescription = servico.nome,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Nome e preço do serviço
        Column {
            Text(
                text = servico.nome,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "R$ ${servico.preco}",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaInicio() {
    TelaInicio(
        state = rememberDrawerState(DrawerValue.Closed), // Simulação do DrawerState
        bottonNavBar = { }
    )
}
