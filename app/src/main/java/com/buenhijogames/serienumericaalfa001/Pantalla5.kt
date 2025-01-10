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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun Pantalla5(modifier: Modifier = Modifier, viewModel: NumeroViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewModel.jugar) {
            Text(text = "numbers: ${viewModel.numbers}", modifier = Modifier.weight(1f))
            Log.e("numbers PRIMERA MEDIDA", viewModel.numbers.toString())
            Log.e("listaNumeros PRIMERA MEDIDA", viewModel.listaNumeros.toString())

            ControlCaja(viewModel.numbers, viewModel)

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.weight(.5f)) {
                Boton(
                    numero = 0,
                    color = Color.Yellow,
                    listaDeEnteros = viewModel.listaNumeros,
                    listaNumeros = viewModel.numbers,
                    onUpdated = { viewModel.listaNumeros = it },
                    onClicked = {
                        viewModel.shouldRecompose = false
                        //Si las lista no coinciden se lanza un mensaje de error
                        if (viewModel.listaNumeros != viewModel.numbers) {
                            Log.e("Error", "Las listas no coinciden")
                            Log.e("listaNumeros", viewModel.listaNumeros.toString())
                            Log.e("numbers", viewModel.numbers.toString())
                        } else {
                            //Si las listas coinciden, se añade un número aleatorio a numbers
                            viewModel.numbers += viewModel.numeroAleatorio()
                            //Se limpia la lista de números
                            viewModel.listaNumeros = emptyList()
                            viewModel.shouldRecompose = !viewModel.shouldRecompose
                            viewModel.mostrarError = false
                        }
                        secuenciaIncorrecta(viewModel.listaNumeros, viewModel.numbers, viewModel)
                    }
                )
                Boton(
                    numero = 1,
                    color = Color.Green,
                    listaDeEnteros = viewModel.listaNumeros,
                    listaNumeros = viewModel.numbers,
                    onUpdated = { viewModel.listaNumeros = it },
                    onClicked = {
                        viewModel.shouldRecompose = false
                        //Si las lista no coinciden se lanza un mensaje de error
                        if (viewModel.listaNumeros != viewModel.numbers) {
                            Log.e("Error", "Las listas no coinciden")
                            Log.e("listaNumeros", viewModel.listaNumeros.toString())
                            Log.e("numbers", viewModel.numbers.toString())
                        } else {
                            //Si las listas coinciden, se añade un número aleatorio a numbers
                            viewModel.numbers += viewModel.numeroAleatorio()
                            //Se limpia la lista de números
                            viewModel.listaNumeros = emptyList()
                            viewModel.shouldRecompose = !viewModel.shouldRecompose
                            viewModel.mostrarError = false
                        }
                        secuenciaIncorrecta(viewModel.listaNumeros, viewModel.numbers, viewModel)
                    }
                )
                Boton(
                    numero = 2,
                    color = Color.Red,
                    listaDeEnteros = viewModel.listaNumeros,
                    listaNumeros = viewModel.numbers,
                    onUpdated = { viewModel.listaNumeros = it },
                    onClicked = {
                        viewModel.shouldRecompose = false
                        //Si las lista no coinciden se lanza un mensaje de error
                        if (viewModel.listaNumeros != viewModel.numbers) {
                            Log.e("Error", "Las listas no coinciden")
                            Log.e("listaNumeros", viewModel.listaNumeros.toString())
                            Log.e("numbers", viewModel.numbers.toString())
                        } else {
                            //Si las listas coinciden, se añade un número aleatorio a numbers
                            viewModel.numbers = viewModel.numbers + viewModel.numeroAleatorio()
                            //Se limpia la lista de números
                            viewModel.listaNumeros = emptyList()
                            viewModel.shouldRecompose = !viewModel.shouldRecompose
                            viewModel.mostrarError = false
                        }
                        secuenciaIncorrecta(viewModel.listaNumeros, viewModel.numbers, viewModel)
                    }
                )
                Boton(
                    numero = 3,
                    color = Color.Blue,
                    listaDeEnteros = viewModel.listaNumeros,
                    listaNumeros = viewModel.numbers,
                    onUpdated = { viewModel.listaNumeros = it },
                    onClicked = {
                        viewModel.shouldRecompose = false
                        //Si las lista no coinciden se lanza un mensaje de error
                        if (viewModel.listaNumeros != viewModel.numbers) {
                            Log.e("Error", "Las listas no coinciden")
                            Log.e("listaNumeros", viewModel.listaNumeros.toString())
                            Log.e("numbers", viewModel.numbers.toString())
                        } else {
                            //Si las listas coinciden, se añade un número aleatorio a numbers
                            viewModel.numbers += viewModel.numeroAleatorio()
                            //Se limpia la lista de números
                            viewModel.listaNumeros = emptyList()
                            viewModel.shouldRecompose = !viewModel.shouldRecompose
                            viewModel.mostrarError = false
                        }
                        secuenciaIncorrecta(viewModel.listaNumeros, viewModel.numbers, viewModel)
                    }
                )
            }

            Text(text = "Lista de números: ${viewModel.listaNumeros}", modifier = Modifier.weight(1f))

            /*Button(
                onClick = { viewModel.inicializar(viewModel); viewModel.jugar = true },
                modifier = Modifier.padding(bottom = 32.dp)
            ) { Text("Lanzar") }*/
        } else {
            Button(
                onClick = { viewModel.inicializar(viewModel); viewModel.mostrarError =false; viewModel.jugar = true },
                modifier = Modifier.padding(bottom = 32.dp)
            ) { Text("Jugar otra vez") }
        }
    }


}



private fun comprobarPrimerElemento(
    listaNumeros: List<Int>,
    numbers: List<Int>,
    viewModel: NumeroViewModel,
) {
    if (listaNumeros[0] != numbers[0]) {
        viewModel.mostrarError = true
    }
}


private fun secuenciaIncorrecta(
    listaNumeros: List<Int>,
    numbers: List<Int>,
    viewModel: NumeroViewModel,
) {
    val minSize = minOf(listaNumeros.size, numbers.size)
    for (i in 0 until minSize) {
        if (listaNumeros[i] != numbers[i]) {
            viewModel.mostrarError = true
            viewModel.jugar = false
        }
    }
}


@Composable
private fun ControlCaja(
    numbers: List<Int>,
    viewModel: NumeroViewModel,
) {
    if (viewModel.mostrarError) {
        Text("Error", color = Color.Red)
    } else {
        if (numbers.size == 1) {
            NumberScroller(numbers = numbers, viewModel = viewModel)
        } else {
            if (viewModel.shouldRecompose) {
                NumberScroller(numbers = numbers, viewModel = viewModel)
            } else {
                /*CajaNegra(viewModel = viewModel)*/
                Caja(viewModel = viewModel, color = Color.White)
            }
        }
    }
}

@Composable
fun CajaNegra(viewModel: NumeroViewModel) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 4.dp)
            .size(120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(viewModel.textCajaNegra)
    }
}

@Composable
fun Caja(viewModel: NumeroViewModel, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 4.dp)
            .size(120.dp)
            .background(color),
    ) {}
}


@Composable
private fun Boton(
    numero: Int,
    color: Color,
    listaDeEnteros: List<Int>,
    listaNumeros: List<Int>,
    onUpdated: (List<Int>) -> Unit,
    onClicked: (List<Int>) -> Unit,
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

@Composable
fun NumberScroller(numbers: List<Int>, viewModel: NumeroViewModel) {
    val currentIndex = remember { mutableIntStateOf(-1) } // -1 para que no se muestre nada
    var showNumber by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        var cont = 0
        while (cont < numbers.size) {
            delay(500)
            currentIndex.intValue = (currentIndex.intValue + 1) % numbers.size
            showNumber = true
            delay(700)
            showNumber = false
            cont++
        }
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 4.dp)
            .size(120.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        if (currentIndex.intValue >= -2 && showNumber) {
            if (numbers[currentIndex.intValue] == 0) {
                Caja(viewModel = viewModel, color = Color.Yellow)
            } else if (numbers[currentIndex.intValue] == 1) {
                Caja(viewModel = viewModel, color = Color.Green)
            } else if (numbers[currentIndex.intValue] == 2) {
                Caja(viewModel = viewModel, color = Color.Red)
            } else if (numbers[currentIndex.intValue] == 3) {
                Caja(viewModel = viewModel, color = Color.Blue)
            }
            /*Text(
                text = numbers[currentIndex.intValue].toString(),
                fontSize = 64.sp,
                color = Color.White
            )*/
        }
    }
}