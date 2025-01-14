package com.buenhijogames.serienumericaalfa001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import com.buenhijogames.serienumericaalfa001.ui.theme.SerieNumericaAlfa001Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = NumeroViewModel(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SerieNumericaAlfa001Theme {
                Column { Pantalla5(viewModel = viewModel) }
            }
        }
    }
}
