package com.example.u_calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.u_calculator.ui.components.CalcButtonComposable
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun UCalculatorApp(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val buttons = Buttons.value

    Column(
        modifier = modifier
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = if (uiState.operation == null && uiState.operand1 != "0") uiState.operand1 else uiState.operand2,
            modifier = Modifier
                .padding(end = 20.dp)
                .align(Alignment.End),
            color = Color.White,
            fontSize = 100.sp
        )
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            for (row in buttons) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    for (button in row) {
                        CalcButtonComposable(
                            text = button.value,
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(if (button.isWide) 2f else 1f),
                            color = button.color,
                            textColor = button.textColor,
                            isWide = button.isWide,
                            onClick = {
                                viewModel.onButtonClick(button.type)
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