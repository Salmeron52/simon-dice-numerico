package com.buenhijogames.serienumericaalfa001

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buenhijogames.serienumericaalfa001.data.RecordDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class NumeroViewModel(private val context: Context) : ViewModel() {

    var listaNumeros by mutableStateOf(listOf<Int>())
    var numbers by mutableStateOf(listOf<Int>(numeroAleatorio()))
    var shouldRecompose by mutableStateOf(false)
    var mostrarError by mutableStateOf(false)
    var jugar by mutableStateOf(true)
    var puntos: Int by mutableIntStateOf(0)
    var record by mutableIntStateOf(0)
    private val recordDataStore = RecordDataStore(context)

    init {
        viewModelScope.launch {
            record = recordDataStore.getRecord.first() // Obtener record inicial
        }
    }

    fun calcularRecord() {
        if (record < puntos) {
            record = puntos
            viewModelScope.launch {
                recordDataStore.saveRecord(record)
            }
        }
    }
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



