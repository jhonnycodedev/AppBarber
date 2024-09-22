package com.example.appbarber.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import com.example.appbarber.components.MenuSuperior

@Composable
fun TelaInicio(state: DrawerState, bottonNavBar: @Composable ()-> Unit){
    Scaffold(
        topBar = { MenuSuperior(state) },
        content = { iPad -> iPad
            Column(modifier = Modifier.fillMaxSize()) {

                Row(modifier =  Modifier
                    .fillMaxWidth()
                    .weight(1f)){
                    Box(modifier = Modifier
                        .background(Color.Red)
                        .fillMaxHeight()
                        .weight(1f)
                    )
                }

                Row(modifier =  Modifier
                    .fillMaxWidth()
                    .weight(1f)){
                    Box(modifier = Modifier
                        .background(Color.Yellow)
                        .fillMaxHeight()
                        .weight(1f)
                    )
                }

                Row(modifier =  Modifier
                    .fillMaxWidth()
                    .weight(1f)){
                    Box(modifier = Modifier
                        .background(Color.Green)
                        .fillMaxHeight()
                        .weight(1f)
                    )
                }
                Row(modifier =  Modifier
                    .fillMaxWidth()
                    .weight(1f)){
                    Box(modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxHeight()
                        .weight(1f)
                    )
                }

            }
        },
        //floatingActionButton = { FloatingButton() },
        bottomBar = { bottonNavBar() }
    )
}

