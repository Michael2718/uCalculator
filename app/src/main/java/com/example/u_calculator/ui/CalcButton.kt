package com.example.u_calculator.ui

data class CalcButton(
    val value: String = "",
    val type: ButtonType = ButtonType.Clear,
    val colorType: ColorType = ColorType.Secondary,
    val isWide: Boolean = false
)

enum class ColorType {
    Primary,
    Secondary,
    Tertiary
}
