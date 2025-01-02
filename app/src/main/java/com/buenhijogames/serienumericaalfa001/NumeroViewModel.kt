package com.buenhijogames.serienumericaalfa001

import androidx.collection.mutableIntListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NumeroViewModel: ViewModel() {

    val listaNumeros by mutableStateOf(listOf<Int>())
    var numbers by  mutableStateOf(listOf<Int>(numeroAleatorio()))
    var shouldRecompose by  mutableStateOf(false)
    val textCajaNegra by mutableStateOf("")
    var mostrarError by mutableStateOf(true)

    fun numeroAleatorio(): Int {
        return (0..3).random() // 0, 1, 2, 3
    }
}

