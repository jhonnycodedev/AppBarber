package com.example.appbarber.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.appbarber.screens.TelaRotasBottom

@Composable
fun MenuInferior(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(TelaRotasBottom.TelaInicio)
            },
            icon = {
                Icon(imageVector = Icons.Filled.Home,
                    contentDescription = "Inicio",
                    modifier = Modifier.size(40.dp))
            },
            label = { Text(text = "Inicio") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TelaRotasBottom.TelaSearchBarber)
            },
            icon = {
                Icon(imageVector = Icons.Filled.Search,
                    contentDescription = "Pesquisar",
                    modifier = Modifier.size(40.dp))
            },
            label = { Text(text = "Pesquisar") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TelaRotasBottom.TelaAgendamento)
            },
            icon = {
                Icon(imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = "Agendamentos",
                    modifier = Modifier.size(40.dp))
            },
            label = { Text(text = "Agendamento") }
        )
    }
}


@Composable
fun BarberBottomBar(){
    BottomAppBar(
        containerColor = Color(0x52196F3)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = Icons.Filled.Home,
                contentDescription = "d",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(50.dp))
            Icon(imageVector = Icons.Filled.Search,
                contentDescription = "e",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(50.dp))

            Icon(imageVector = Icons.Filled.CalendarMonth,
                contentDescription = "c",
                modifier = Modifier.size(40.dp))
        }
    }
}
