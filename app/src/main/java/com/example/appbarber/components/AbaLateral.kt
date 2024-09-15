package com.example.appbarber.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appbarber.R
import com.example.appbarber.screens.BarberAppRotas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AbaLateral(
    navController: NavController,
    state: DrawerState,
    rotaAtual: String,
    coroutineScope: CoroutineScope
) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
            .background(colorResource(id = R.color.principal))
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        DrawerButton(
            selected = rotaAtual == BarberAppRotas.TELA_CONTA,
            icon = Icons.Filled.AccountCircle,
            text = "Meus Dados",
            onClick = {
                navController.navigate(BarberAppRotas.TELA_CONTA)
                coroutineScope.launch { state.close() }
            }
        )

        DrawerButton(
            selected = rotaAtual == BarberAppRotas.TELA_UM,
            icon = Icons.Filled.FavoriteBorder,
            text = "Favoritos",
            onClick = {
                navController.navigate(BarberAppRotas.TELA_UM)
                coroutineScope.launch { state.close() }
            }
        )

        DrawerButton(
            selected = rotaAtual == BarberAppRotas.TELA_DOIS,
            icon = Icons.Filled.Lock,
            text = "Segurança",
            onClick = {
                navController.navigate(BarberAppRotas.TELA_DOIS)
                coroutineScope.launch { state.close() }
            }
        )

        DrawerButton(
            selected = rotaAtual == BarberAppRotas.TELA_TRES,
            icon = Icons.Filled.ManageAccounts,
            text = "Meus Acessos",
            onClick = {
                navController.navigate(BarberAppRotas.TELA_TRES)
                coroutineScope.launch { state.close() }
            }
        )

        DrawerButton(
            selected = rotaAtual == BarberAppRotas.TELA_QUATRO,
            icon = Icons.Filled.Payment,
            text = "Meus Cartões",
            onClick = {
                navController.navigate(BarberAppRotas.TELA_QUATRO)
                coroutineScope.launch { state.close() }
            }
        )

        Spacer(modifier = Modifier.height(300.dp))

        TextButton(
            onClick = {
                navController.navigate("login_screen")
                coroutineScope.launch { state.close() }
            }
        ) {
            Text(
                color = Color.Red,
                text = "Sair",
                fontSize = 20.sp,
                modifier = Modifier.padding(30.dp, 5.dp)
            )
        }
    }
}

@Composable
fun DrawerButton(
    selected: Boolean,
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        colors = ButtonDefaults.buttonColors(containerColor = getBack(selected)),
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(30.dp), // Ajuste o tamanho do ícone aqui
            tint = getTint(selected)
        )
        Spacer(modifier = Modifier.width(16.dp)) // Espaço entre o ícone e o texto
        Text(
            color = getTint(selected),
            text = text,
            fontSize = 20.sp, // Ajuste o tamanho do texto aqui
            modifier = Modifier.padding(8.dp)
        )
    }
}

fun getTint(selected: Boolean): Color {
    return if (selected) Color.Black
    else Color.DarkGray
}

fun getBack(selected: Boolean): Color {
    return if (selected) Color.Yellow
    else Color.Transparent
}
