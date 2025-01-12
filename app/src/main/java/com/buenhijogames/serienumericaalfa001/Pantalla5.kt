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
import androidx.compose.material3.OutlinedButton
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
import com.buenhijogames.serienumericaalfa001.componentes.BotonUsuario
import com.buenhijogames.serienumericaalfa001.componentes.Caja
import com.buenhijogames.serienumericaalfa001.componentes.ControlCaja
import com.buenhijogames.serienumericaalfa001.componentes.MostrarError
import com.buenhijogames.serienumericaalfa001.componentes.MostrarErrorParpadeante
import kotlinx.coroutines.delay

@Composable
fun Pantalla5(modifier: Modifier = Modifier, viewModel: NumeroViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (viewModel.jugar) {
            /*Text(text = "numbers: ${viewModel.numbers}")*/
            Text(text = "buenhijoGames", color = Color.White, fontSize = 24.sp)

            Spacer(modifier = Modifier.height(64.dp))

            ControlCaja(viewModel.numbers, viewModel)

            Spacer(modifier = Modifier.height(24.dp))

            Row {
                BotonUsuario(viewModel, 0, Color.Yellow)
                BotonUsuario(viewModel, 1, Color.Green)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                BotonUsuario(viewModel, 2, Color.Red)
                BotonUsuario(viewModel, 3, Color.Blue) }

            /*Text(text = "Lista de números: ${viewModel.listaNumeros}")*/
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MostrarErrorParpadeante(viewModel, modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedButton(
                    onClick = {
                        viewModel.inicializar(viewModel)
                        viewModel.mostrarError = false
                        viewModel.jugar = true
                    },
                    modifier = Modifier.padding(bottom = 32.dp)
                ) { Text("Jugar otra vez", color = Color.Yellow, fontSize = 24.sp) }
            }
        }
    }

}



