package com.example.u_calculator.data

sealed class ButtonOperation(val value: String) {
    object Addition: ButtonOperation("+")
    object Subtraction: ButtonOperation("-")
    object Multiplication: ButtonOperation("*")
    object Division: ButtonOperation("/")
    object Percentage: ButtonOperation("%")
    object Sign: ButtonOperation("+/-")
}
