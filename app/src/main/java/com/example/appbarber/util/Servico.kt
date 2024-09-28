package com.example.appbarber.util

data class Servico(
    val nome: String,
    val preco: String,  // preço formatado como String
    val imageResId: Int? = null // opcional, caso haja uma imagem associada ao serviço
)
