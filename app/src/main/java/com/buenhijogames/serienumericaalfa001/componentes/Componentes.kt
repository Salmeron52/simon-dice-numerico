package com.buenhijogames.serienumericaalfa001.componentes

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buenhijogames.serienumericaalfa001.NumeroViewModel
import com.buenhijogames.serienumericaalfa001.data.RecordDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BotonUsuario(viewModel: NumeroViewModel, numero: Int, color: Color) {
    Boton(
        numero = numero,
        color = color,
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
                viewModel.puntos += 10
                //Se limpia la lista de números
                viewModel.listaNumeros = emptyList()
                viewModel.shouldRecompose = !viewModel.shouldRecompose
                viewModel.mostrarError = false
            }
            secuenciaIncorrecta(viewModel.listaNumeros, viewModel.numbers, viewModel)
        }
    )
}

@Composable
fun Boton(
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
            .size(160.dp)
            .background(color)
            .clickable { onUpdated(listaDeEnteros + numero); onClicked(listaNumeros) },
        contentAlignment = Alignment.Center
    ) { Text(numero.toString(), fontSize = 24.sp) }
}

fun secuenciaIncorrecta(
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

fun ControlCaja(
    numbers: List<Int>,
    viewModel: NumeroViewModel,
) {
    if (viewModel.mostrarError) {
        MostrarError()
    } else {
        if (numbers.size == 1) {
            NumberScroller(numbers = numbers, viewModel = viewModel)
        } else {
            if (viewModel.shouldRecompose) {
                NumberScroller(numbers = numbers, viewModel = viewModel)
            } else {
                Caja(viewModel = viewModel, color = Color.Black)
            }
        }
    }
}

@Composable
fun MostrarErrorParpadeante(viewModel: NumeroViewModel, modifier: Modifier = Modifier) {

    var showError by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(600)
            showError = !showError
        }
    }
    if(showError) MostrarError() else Text("Hola", fontSize = 60.sp)
}

@Composable
fun MostrarError() {
    Text("¡Error!", color = Color.Red, fontSize = 60.sp)
}


@Composable
fun NumberScroller(numbers: List<Int>, viewModel: NumeroViewModel) {
    val currentIndex = remember { mutableIntStateOf(-1) } // -1 para que no se muestre nada
    var showNumber by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        var cont = 0
        while (cont < numbers.size) {
            delay(400)
            currentIndex.intValue = (currentIndex.intValue + 1) % numbers.size
            showNumber = true
            delay(400)
            showNumber = false
            cont++
        }
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 4.dp)
            .size(120.dp)
            .background(Color.Black),
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
        }
    }
}

@Composable
fun MostrarMarcador(viewModel: NumeroViewModel) {
    val context: Context = LocalContext.current
    val scope = rememberCoroutineScope()
    val recordDataStore = RecordDataStore(context)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        LaunchedEffect(key1 = viewModel.record) { scope.launch { recordDataStore.saveRecord(viewModel.record) } }
        val userRecord = recordDataStore.getRecord.collectAsState(initial = 0)

        Text("Score: ${viewModel.puntos}", color = Color.White, fontSize = 18.sp)
        Text(
            " Record: ${userRecord.value}",
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Right
        )
    }
}