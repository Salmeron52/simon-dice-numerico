package com.buenhijogames.serienumericaalfa001

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pantalla(viewModel: NumeroViewModel) {
    var numbers by remember { mutableStateOf(listOf<Int>()) }
    var listaNumeros by remember { mutableStateOf(listOf<Int>()) }
    var shouldRecompose by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de números: $numbers", modifier = Modifier.weight(1f))

        Row(modifier = Modifier.weight(.9f)) {
            Boton(0, Color.Yellow, listaNumeros) { listaNumeros = it }
            Boton(1, Color.Green, listaNumeros) { listaNumeros = it }
            Boton(2, Color.Red, listaNumeros) { listaNumeros = it }
            Boton(3, Color.Blue, listaNumeros) { listaNumeros = it }
        }

        Text(text = "Lista de números: $listaNumeros", modifier = Modifier.weight(1f))

        Button(onClick = {
            numbers = numbers + viewModel.numeroAleatorio()
            shouldRecompose = !shouldRecompose
        }) {
            Text(text = "Agregar número")
        }
    }
}

@Composable
private fun Boton(
    numero: Int,
    color: Color,
    listaDeEnteros: List<Int>,
    onUpdated: (List<Int>) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 4.dp)
            .size(60.dp)
            .background(color)
            .clickable { onUpdated(listaDeEnteros + numero) },
        contentAlignment = Alignment.Center
    ) { Text(numero.toString(), fontSize = 24.sp) }
}