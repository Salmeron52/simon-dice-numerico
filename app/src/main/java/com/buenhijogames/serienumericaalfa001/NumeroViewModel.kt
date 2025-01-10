package com.buenhijogames.serienumericaalfa001

import androidx.collection.mutableIntListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class NumeroViewModel: ViewModel() {

    var listaNumeros by mutableStateOf(listOf<Int>())
    var numbers by  mutableStateOf(listOf<Int>(numeroAleatorio()))
    var shouldRecompose by  mutableStateOf(false)
    val textCajaNegra by mutableStateOf("")
    var mostrarError by mutableStateOf(false)
    var jugar by mutableStateOf(true)

    fun numeroAleatorio(): Int {
        return (0..3).random() // 0, 1, 2, 3
    }

    fun inicializar(viewModel: NumeroViewModel) {
        //vaciamos numbers
        numbers = emptyList<Int>()
        numbers = numbers + numeroAleatorio()
        //vaciamos listaNumeros
        listaNumeros = emptyList<Int>()
    }
}

