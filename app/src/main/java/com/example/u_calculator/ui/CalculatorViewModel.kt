package com.example.u_calculator.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState()
    )

    val uiState: StateFlow<HomeUiState> = _uiState

    fun onButtonClick(buttonType: ButtonType) {
        when (buttonType) {
            is ButtonType.Calculate -> calculate()
            is ButtonType.Clear -> clear()
            is ButtonType.Decimal -> appendDecimal()
            is ButtonType.Digit -> appendDigit(buttonType.digit)
            is ButtonType.Operation -> updateOperation(buttonType.operation)
        }
    }

    private fun calculate() { // TODO: Fix bug with empty string
        _uiState.update { state ->
            val (operand1, operand2, operation) = state
            val number1 = operand1.toDouble()
            val number2 = operand2.toDouble()
            val result = when (operation) {
                ButtonOperation.Addition -> number1 + number2
                ButtonOperation.Subtraction -> number1 - number2
                ButtonOperation.Multiplication -> number1 * number2
                ButtonOperation.Division -> number1 / number2
                ButtonOperation.Percentage -> number1 % number1 // TODO: Percentage takes 1/100 out of operand1
                null -> number1
            }
            state.copy(
                operand1 = result.toString().take(16),
                operand2 = "",
                operation = null
            )
        }
    }

    private fun clear() {
        _uiState.update { HomeUiState() }
    }

    private fun appendDecimal() {
        _uiState.update { state ->
            val (operand1, operand2, operation) = state
            state.copy(
                operand1 = if (operation == null && "." !in operand1) "$operand1." else operand1,
                operand2 = if (operation != null && "." !in operand2) "$operand2." else operand2
            )
        }
    }

    private fun appendDigit(digit: String) {
        _uiState.update { state ->
            val (operand1, operand2, operation) = state
            state.copy(
                operand1 = if (operation == null) if (operand1 == "0") digit else operand1 + digit else operand1,
                operand2 = if (operation != null) if (operand2 == "0") digit else operand2 + digit else operand2
            )
        }
    }

    private fun updateOperation(operation: ButtonOperation) {
        _uiState.update { state ->
            if (state.operation != null && state.operand2.isNotEmpty()) {
                calculate()
            }
            state.copy(
                operation = operation
            )
        }
    }
}

data class HomeUiState(
    val operand1: String = "0",
    val operand2: String = "0",
    val operation: ButtonOperation? = null
)
