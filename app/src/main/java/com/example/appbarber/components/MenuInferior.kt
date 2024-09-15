package com.example.appbarber.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbarber.R


@Composable
fun MenuInferior(state: DrawerState) {
    BottomAppBar(
        containerColor = colorResource(id = R.color.principal),
        contentColor = Color.White
    ) {
        // Ícones centrais com nomes embaixo
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(5f) // Distribuir espaço proporcionalmente
        ) {
            // Ícone Home com nome
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Inicio",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
                Text(
                    text = "Início",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.bottonbar)
                )
            }

            Spacer(modifier = Modifier.width(60.dp))

            // Ícone Search com nome
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
                Text(
                    text = "Buscar",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.bottonbar)
                )
            }

            Spacer(modifier = Modifier.width(50.dp))

            // Ícone DateRange com nome
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Agendamentos",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
                Text(
                    text = "Agendamento",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.bottonbar)
                )
            }
        }
    }

    @Composable
    fun BottomBarButton(icon: ImageVector, label: String, onClick: () -> Unit) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
            Text(
                text = label,
                fontSize = 12.sp,
                color = colorResource(id = R.color.bottonbar)
            )
        }
    }
}
