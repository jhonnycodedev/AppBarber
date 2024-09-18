package com.example.appbarber.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appbarber.R
import kotlinx.coroutines.launch

object BarberAppRotas {
    const val TELA_UM = "navegação"
    const val TELA_DOIS = "segurança"
    const val TELA_TRES = "meus acessos"
    const val TELA_QUATRO = "cartoes"
    const val TELA_CINCO = "conta"
    const val TELA_SEIS = "favoritos"
}

@Preview
@Composable
fun PrincipalPage() {
    val state = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()
    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: BarberAppRotas.TELA_UM

    val telaUmSelect = rotaAtual == BarberAppRotas.TELA_UM
    val telaDoisSelect = rotaAtual == BarberAppRotas.TELA_DOIS
    val telaTresSelect = rotaAtual == BarberAppRotas.TELA_TRES
    val telaQuatroSelect = rotaAtual == BarberAppRotas.TELA_QUATRO
    val telaCincoSelect = rotaAtual == BarberAppRotas.TELA_CINCO
    val telaSeisSelect = rotaAtual == BarberAppRotas.TELA_SEIS


    ModalNavigationDrawer(
        drawerState = state,
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.principal))
            ) {
                Spacer(modifier = Modifier.height(70.dp))

                TextButton(
                    onClick = {
                        navController.navigate(BarberAppRotas.TELA_UM)
                        coroutineScope.launch { state.close() }
                    }) {

                }

                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = getBack(telaDoisSelect)
                    ),
                    onClick = {
                        navController.navigate(BarberAppRotas.TELA_DOIS)
                        coroutineScope.launch { state.close() }
                    }) {

                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Segurança",
                        modifier = Modifier.size(30.dp),
                        tint = getTint(telaDoisSelect))

                    Text(
                        color = getTint(telaDoisSelect),
                        text = "Segurança", fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }


                TextButton( colors = ButtonDefaults.buttonColors(
                    containerColor = getBack(telaTresSelect)
                ),
                    onClick = {
                        navController.navigate(BarberAppRotas.TELA_TRES)
                        coroutineScope.launch { state.close() }
                    }) {


                    Icon(
                        imageVector = Icons.Filled.ManageAccounts,
                        contentDescription = "Meus Acessos",
                        modifier = Modifier.size(30.dp),
                        tint = getTint(telaTresSelect))

                    Text(
                        color = getTint(telaTresSelect),
                        text = "Meus Acessos", fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                TextButton( colors = ButtonDefaults.buttonColors(
                    containerColor = getBack(telaQuatroSelect)
                ),
                    onClick = {
                        navController.navigate(BarberAppRotas.TELA_QUATRO)
                        coroutineScope.launch { state.close() }
                    }) {


                    Icon(
                        imageVector = Icons.Filled.Payment,
                        contentDescription = "Cartões",
                        modifier = Modifier.size(30.dp),
                        tint = getTint(telaQuatroSelect))

                    Text(
                        color = getTint(telaQuatroSelect),
                        text = "Cartões", fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                TextButton( colors = ButtonDefaults.buttonColors(
                    containerColor = getBack(telaCincoSelect)
                ),
                    onClick = {
                        navController.navigate(BarberAppRotas.TELA_CINCO)
                        coroutineScope.launch { state.close() }
                    }) {


                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Conta",
                        modifier = Modifier.size(30.dp),
                        tint = getTint(telaCincoSelect))

                    Text(
                        color = getTint(telaCincoSelect),
                        text = "Conta", fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = getBack(telaSeisSelect)
                    ),
                    onClick = {
                        navController.navigate(BarberAppRotas.TELA_SEIS)
                        coroutineScope.launch { state.close() }
                    }) {

                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "Favoritos",
                        modifier = Modifier.size(30.dp),
                        tint = getTint(telaSeisSelect))

                    Text(
                        color = getTint(telaSeisSelect),
                        text = "Favoritos", fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

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
        },
        content = {
            BarberNavHost(navController, state)
        }
    )
}

@Composable
private fun BarberNavHost(
    navController: NavHostController,
    state: DrawerState
) {
    NavHost(
        navController = navController,
        startDestination = BarberAppRotas.TELA_UM
    ) {
        composable(BarberAppRotas.TELA_UM) {
            TelaUm(state)
        }
        composable(BarberAppRotas.TELA_DOIS) {
            TelaDois(state)
        }
        composable(BarberAppRotas.TELA_TRES) {
            TelaTres(state)
        }
        composable(BarberAppRotas.TELA_QUATRO) {
            TelaQuatro(state)
        }
        composable(BarberAppRotas.TELA_CINCO) {
            TelaCinco(state)
        }
        composable(BarberAppRotas.TELA_SEIS) {
            TelaSeis(state)
        }

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




