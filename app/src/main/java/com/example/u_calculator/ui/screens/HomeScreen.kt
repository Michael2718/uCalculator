package com.example.u_calculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.u_calculator.ui.ButtonType
import com.example.u_calculator.ui.CalcButton
import com.example.u_calculator.ui.CalculatorUiState
import com.example.u_calculator.ui.ColorType
import com.example.u_calculator.ui.components.AutoSizeText
import com.example.u_calculator.ui.components.CalcButtonComposable

@Composable
fun HomeScreen(
    uiState: CalculatorUiState,
    buttons: List<List<CalcButton>>,
    onButtonClick: (ButtonType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .height(140.dp)
                .padding(horizontal = 20.dp)
        ) {
            AutoSizeText(
                text = uiState.currentInput,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .align(Alignment.Bottom)
            )
        }
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
                            backgroundColor = when (button.colorType) {
                                ColorType.Primary -> MaterialTheme.colorScheme.primary
                                ColorType.Secondary -> MaterialTheme.colorScheme.secondary
                                ColorType.Tertiary -> MaterialTheme.colorScheme.tertiary
                            },
                            textColor = when (button.colorType) {
                                ColorType.Primary -> MaterialTheme.colorScheme.onPrimary
                                ColorType.Secondary -> MaterialTheme.colorScheme.onSecondary
                                ColorType.Tertiary -> MaterialTheme.colorScheme.onTertiary
                            },
                            fontSize = when (button.type) {
                                ButtonType.Clear -> 36.sp
                                is ButtonType.Operation -> if (button.colorType == ColorType.Tertiary) {
                                    32.sp
                                } else {
                                    48.sp
                                }

                                else -> 40.sp
                            },
                            fontWeight = when (button.type) {
                                ButtonType.Clear -> FontWeight.Medium
                                is ButtonType.Operation -> FontWeight.Medium
                                else -> FontWeight.Normal
                            },
                            isWide = button.isWide,
                            onClick = {
                                onButtonClick(button.type)
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(if (button.isWide) 2f else 1f)
                        )
                    }
                }
            }
        }
    }
}
