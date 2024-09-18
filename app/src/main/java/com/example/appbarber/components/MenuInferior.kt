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
    // Obtém a navegação atual
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == TelaRotasBottom.TelaMenuA,
            onClick = {
                navController.navigate(TelaRotasBottom.TelaMenuA) {
                    // Use popUpTo e launchSingleTop para evitar múltiplas instâncias
                    popUpTo(TelaRotasBottom.TelaMenuA) { inclusive = true }
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Inicio",
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == TelaRotasBottom.TelaMenuB,
            onClick = {
                navController.navigate(TelaRotasBottom.TelaMenuB) {
                    popUpTo(TelaRotasBottom.TelaMenuB) { inclusive = true }
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Pesquisar",
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == TelaRotasBottom.TelaMenuC,
            onClick = { navController.navigate(TelaRotasBottom.TelaMenuC) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = "Calendário",
                    modifier = Modifier.size(40.dp)
                )
            }
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
