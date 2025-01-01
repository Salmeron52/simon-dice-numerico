package com.buenhijogames.serienumericaalfa001

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun Pantalla4(modifier: Modifier = Modifier) {
    val numbers = listOf(1, 4, 2, 8, 5)
    NumberScroller(numbers = numbers)
}

@Composable
private fun NumberScroller(numbers: List<Int>) {
    val currentIndex = remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        var cont = 1
        while (cont < numbers.size) {
            delay(1000)
            currentIndex.intValue = (currentIndex.intValue + 1) % numbers.size
            cont ++
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = numbers[currentIndex.intValue].toString())
    }
}