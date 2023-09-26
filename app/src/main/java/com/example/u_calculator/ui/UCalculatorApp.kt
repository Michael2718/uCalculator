package com.example.u_calculator.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.u_calculator.ui.components.CalcButton
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun UCalculatorApp(
    modifier: Modifier = Modifier,
    // viewModel
) {
    val list = listOf(
        "AC", "+/-", "%", "/",
        "7", "8", "9", "*",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", "0", ".", "="
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(4)
    ) {
        itemsIndexed(items = list) { index, item ->
            CalcButton(
                text = item,
                color = if (index in (0..2)) {
                    Color(red = 165, green = 165, blue = 165)
                } else if ((index + 1) % 4 == 0) {
                    Color(red = 51, green = 51, blue = 51)
                } else {
                    Color(red = 255, green = 159, blue = 10)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UCalculatorAppPreview() {
    UCalculatorTheme {
        UCalculatorApp()
    }
}