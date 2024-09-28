package com.example.appbarber.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.appbarber.util.Barbeiro

@Composable
fun BarbeiroItem(barbeiro: Barbeiro) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { /* Ação de clique para abrir detalhes */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(barbeiro.imageResId),
            contentDescription = barbeiro.name,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = barbeiro.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = barbeiro.location, fontSize = 14.sp, color = Color.Gray)
        }
    }
}
