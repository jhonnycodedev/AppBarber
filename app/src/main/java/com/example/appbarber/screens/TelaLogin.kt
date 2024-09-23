package com.example.appbarber.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.appbarber.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

@Composable
fun TelaLogin(onLoginSuccess: () -> Unit) {
    // Definir as credenciais corretas
    val correctEmail = "teste"
    val correctPassword = "123"

    // Variáveis de estado para armazenar email, senha e a mensagem de erro
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }  // Mensagem de erro

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(color = Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Logotipo no topo
                Image(
                    painter = painterResource(id = R.drawable.logo3), // Substitua pelo nome da sua imagem
                    contentDescription = "Logotipo",
                    modifier = Modifier
                        .size(300.dp) // Tamanho do logotipo
                        .padding(bottom = 16.dp) // Espaçamento abaixo do logotipo
                )

                // Título
                Text(
                    text = "Bem-Vindo",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Campo de Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo de Senha
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Exibir mensagem de erro, se houver
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                // Botão de Login
                Button(
                    onClick = {
                        if (email == correctEmail && password == correctPassword) {
                            errorMessage = "" // Limpa a mensagem de erro
                            onLoginSuccess()
                        } else {
                            errorMessage = "Credenciais inválidas" // Atualiza a mensagem de erro
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.principal), // Cor de fundo do botão
                        contentColor = Color.White // Cor do texto do botão
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Entre")
                }
            }

        },


    )


}
