package com.example.appbarber.util

import com.example.appbarber.R


data class Barbeiro(
    val name: String,
    val location: String,
    val imageResId: Int // ID da imagem de recurso (drawable)
)

// Lista de Barbeiros para pré-exibir
val originalBarbeiros = listOf(
    Barbeiro("Barbeiro chique no ultimo", "Batel", R.drawable.barbeiro1),
    Barbeiro("Deuses da Navalha", "Colombo", R.drawable.logo1),
    Barbeiro("Barbearia do Zé", "Piraquara", R.drawable.logo2),
    Barbeiro("Corte & Cia", "Bairro Alto", R.drawable.logo4),
    Barbeiro("Corte & Barba", "Pinhais", R.drawable.semfoto),
    Barbeiro("Ai q gatuu..", "Tatuquara", R.drawable.logo5)
)
