package com.example.u_calculator.ui

import androidx.compose.ui.graphics.Color

data class CalcButton(
    val value: String = "",
    val type: ButtonType = ButtonType.Clear,
    val color: Color = Color(0xFF333333),
    val textColor: Color = Color.White,
    val isWide: Boolean = false
)
