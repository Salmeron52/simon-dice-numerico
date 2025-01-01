package com.buenhijogames.serienumericaalfa001

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun Pantalla3(modifier: Modifier = Modifier, viewModel: NumeroViewModel) {
    var numbers by remember { mutableStateOf(listOf<Int>(viewModel.numeroAleatorio())) }
    var listaNumeros by remember { mutableStateOf(listOf<Int>()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "numbers: $numbers", modifier = Modifier.weight(.7f))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .padding(horizontal = 4.dp)
                .size(120.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            for (number in numbers) {
                Text(
                    text = numbers.last().toString(),
                    fontSize = 48.sp,
                    color = Color.White
                )
                //esperamos medio segundo
                Thread.sleep(500)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.weight(.2f)) {
            Boton(
                numero = 0,
                color = Color.Yellow,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },
                onClicked = {
                    //Si las lista no coinciden se lanza un mensaje de error
                    if (listaNumeros != numbers) {
                        Log.e("Error", "Las listas no coinciden")
                    } else {
                        //Si las listas coinciden, se añade un número aleatorio a numbers
                        numbers = numbers + viewModel.numeroAleatorio()
                    }
                }
            )
            Boton(
                numero = 1,
                color = Color.Green,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },
                onClicked = {
                    //Si las lista no coinciden se lanza un mensaje de error
                    if (listaNumeros != numbers) {
                        Log.e("Error", "Las listas no coinciden")
                    } else {
                        //Si las listas coinciden, se añade un número aleatorio a numbers
                        numbers = numbers + viewModel.numeroAleatorio()
                    }
                }
            )
            Boton(
                numero = 2,
                color = Color.Red,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },
                onClicked = {
                    //Si las lista no coinciden se lanza un mensaje de error
                    if (listaNumeros != numbers) {
                        Log.e("Error", "Las listas no coinciden")
                    } else {
                        //Si las listas coinciden, se añade un número aleatorio a numbers
                        numbers = numbers + viewModel.numeroAleatorio()
                    }
                }
            )
            Boton(
                numero = 3,
                color = Color.Blue,
                listaDeEnteros = listaNumeros,
                listaNumeros = numbers,
                onUpdated = { listaNumeros = it },
                onClicked = {
                    //Si las lista no coinciden se lanza un mensaje de error
                    if (listaNumeros != numbers) {
                        Log.e("Error", "Las listas no coinciden")
                    } else {
                        //Si las listas coinciden, se añade un número aleatorio a numbers
                        numbers = numbers + viewModel.numeroAleatorio()
                    }
                }
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