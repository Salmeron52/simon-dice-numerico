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
fun Pantalla2(modifier: Modifier = Modifier, viewModel: NumeroViewModel) {
    var numbers by remember { mutableStateOf(listOf<Int>(viewModel.numeroAleatorio())) }
    var listaNumeros by remember { mutableStateOf(listOf<Int>()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "numbers: $numbers", modifier = Modifier.weight(1f))

        Row(modifier = Modifier.weight(.9f)) {
            Boton(
                numero = 0,
                color = Color.Yellow,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },
                onClicked = {
                    numbers = numbers + viewModel.numeroAleatorio()
                }
            )
            Boton(
                numero = 1,
                color = Color.Green,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },
                onClicked = { numbers += viewModel.numeroAleatorio() }
            )
            Boton(
                numero = 2,
                color = Color.Red,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },// Es lo mismo que listaNumeros = listaNumeros + 2
                onClicked = { numbers += viewModel.numeroAleatorio() }
            )
            Boton(
                numero = 3,
                color = Color.Blue,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it }, // Es lo mismo que listaNumeros = listaNumeros + 3
                onClicked = { numbers += viewModel.numeroAleatorio() }
            )
        }

        Text(text = "Lista de números: $listaNumeros", modifier = Modifier.weight(1f))
    }
}

@Composable
private fun Boton(
    numero: Int,
    color: Color,
    listaDeEnteros: List<Int>,
    listaNumeros: List<Int>,
    onUpdated: (List<Int>) -> Unit,
    onClicked: (List<Int>) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 4.dp)
            .size(60.dp)
            .background(color)
            .clickable { onUpdated(listaDeEnteros + numero); onClicked(listaNumeros) },
        contentAlignment = Alignment.Center
    ) { Text(numero.toString(), fontSize = 24.sp) }
}