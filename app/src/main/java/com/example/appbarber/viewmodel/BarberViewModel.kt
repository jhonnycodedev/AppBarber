package com.example.appbarber.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.appbarber.data.Barbeiro

class BarberViewModel : ViewModel() {
    private val _barbearias = mutableStateListOf<Barbeiro>()
    val barbearias: List<Barbeiro> get() = _barbearias

    fun toggleFavorito(barbeiro: Barbeiro) {
        barbeiro.isFavorito = !barbeiro.isFavorito
        if (barbeiro.isFavorito) {
            if (!_barbearias.contains(barbeiro)) {
                _barbearias.add(barbeiro)
            }
        } else {
            _barbearias.remove(barbeiro)
        }
    }
}
