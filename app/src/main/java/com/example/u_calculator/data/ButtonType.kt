package com.example.u_calculator.data

sealed class ButtonType {
    data class Operation(val operation: ButtonOperation): ButtonType()
    data class Digit(val digit: String) : ButtonType()
    object Clear: ButtonType()
    object Decimal: ButtonType()
    object Calculate: ButtonType()
}
