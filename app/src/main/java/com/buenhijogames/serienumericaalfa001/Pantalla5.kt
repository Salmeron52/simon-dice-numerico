package com.buenhijogames.serienumericaalfa001

import androidx.compose.foundation.background
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
import com.buenhijogames.serienumericaalfa001.componentes.BotonUsuario
import com.buenhijogames.serienumericaalfa001.componentes.Caja
import com.buenhijogames.serienumericaalfa001.componentes.ControlCaja
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

            ControlCaja(viewModel.numbers, viewModel)

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.weight(.5f)) {
                BotonUsuario(viewModel, 0, Color.Yellow)
                BotonUsuario(viewModel, 1, Color.Green)
                BotonUsuario(viewModel, 2, Color.Red)
                BotonUsuario(viewModel, 3, Color.Blue)
            }

            Text(
                text = "Lista de números: ${viewModel.listaNumeros}",
                modifier = Modifier.weight(1f)
            )
        } else {
            Button(
                onClick = {
                    viewModel.inicializar(viewModel)
                    viewModel.mostrarError = false
                    viewModel.jugar = true
                },
                modifier = Modifier.padding(bottom = 32.dp)
            ) { Text("Jugar otra vez") }
        }
    }

}



