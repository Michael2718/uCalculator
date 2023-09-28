package com.example.u_calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.u_calculator.ui.components.CalcButton
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun UCalculatorApp(
    modifier: Modifier = Modifier,
    // viewModel
) {
    val list = listOf(
        listOf("AC", "+/-", "%", "/"),
        listOf("7", "8", "9", "*"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0", "0", ".", "=")
    )
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "0",
            modifier = Modifier.padding(end = 16.dp),
            color = Color.White,
            fontSize = 100.sp
        )
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
//            verticalArrangement = Arrangement.spacedBy(space = 14.dp, alignment = Alignment.Bottom),
        ) {
            for ((rowIndex, row) in list.withIndex()) {
                LazyRow(
                    modifier = Modifier,
//                        .fillMaxWidth(),//.weight(1f),
//                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    userScrollEnabled = false
                ) {
                    itemsIndexed(items = row) { columnIndex, item ->
                        CalcButton(
                            text = item,
                            modifier = Modifier
                                .size(88.dp)
                                .padding(8.dp),
                            color = if (rowIndex == 0 && columnIndex in (0..2)) {
                                Color(0xFFa5a5a5)
                            } else if ((columnIndex + 1) % 4 == 0) {
                                Color(0xFFff9f0a)// Color(0xFFF1A33B)
                            } else {
                                Color(0xFF333333)
                            },
                            textColor = if (rowIndex == 0 && columnIndex in (0..2)) {
                                Color.Black
                            } else {
                                Color.White
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UCalculatorAppPreview() {
    UCalculatorTheme {
        UCalculatorApp()
    }
}