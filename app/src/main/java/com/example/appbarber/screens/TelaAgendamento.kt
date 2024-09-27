package com.example.appbarber.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.R
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.remember
import com.example.appbarber.components.MenuSuperior
import java.text.SimpleDateFormat
import java.util.*

data class Agendamento(
    val name: String,
    val serviceValue: Double,
    val date: Date,
    val imageResId: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaAgendamento(state: DrawerState, bottonNavBar: @Composable () -> Unit) {
    // Lista simulada de agendamentos
    val agendamentos = remember {
        mutableStateListOf(
            Agendamento("Barbearia do Zé", 50.0, Date(), R.drawable.logo2),
            Agendamento("Corte Rápido", 40.0, Date(), R.drawable.logo2),
            Agendamento("Barba e Cabelo", 70.0, Date(), R.drawable.logo2)
        )
    }

    Scaffold(
        //topBar = { MenuSuperior(state) },
        content = { paddingValues ->
            ConteudoTelaAgendamento(
                modifier = Modifier.padding(paddingValues),
                agendamentos = agendamentos,
                onDelete = { agendamento ->
                    agendamentos.remove(agendamento) // Excluir o agendamento da lista
                }
            )
        },
        bottomBar = { bottonNavBar() }
    )
}

@Composable
fun ConteudoTelaAgendamento(
    modifier: Modifier,
    agendamentos: List<Agendamento>,
    onDelete: (Agendamento) -> Unit // Função chamada ao clicar na lixeira
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        agendamentos.forEach { agendamento ->
            AgendamentoItem(agendamento = agendamento, onDelete = onDelete)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun AgendamentoItem(
    agendamento: Agendamento,
    onDelete: (Agendamento) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagem da barbearia
        Image(
            painter = painterResource(agendamento.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            // Nome da barbearia
            Text(
                text = agendamento.name,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Valor do serviço
            Text(
                text = "R$ ${agendamento.serviceValue}",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium
            )

            // Data do agendamento formatada
            val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
            Text(
                text = "Data: ${dateFormatter.format(agendamento.date)}",
                fontSize = 14.sp,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Ícone de lixeira para deletar o agendamento
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Excluir agendamento",
            tint = Color.Red,
            modifier = Modifier
                .size(24.dp)
                .clickable { onDelete(agendamento) } // Ação ao clicar
        )

    }
}

