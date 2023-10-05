package com.example.u_calculator.ui

import androidx.lifecycle.ViewModel
import com.example.u_calculator.data.ButtonOperation
import com.example.u_calculator.data.ButtonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.util.Stack

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())

    val uiState: StateFlow<CalculatorUiState> = _uiState

    fun onButtonClick(buttonType: ButtonType) {
        _uiState.update { state ->
            state.copy(
                isCleared = false
            )
        }

        when (buttonType) {
            is ButtonType.Calculate -> {
                pushNumber(_uiState.value.currentInput.toDouble())
                calculate()
            }

            is ButtonType.Clear -> clear()
            is ButtonType.Decimal -> appendDecimal()
            is ButtonType.Digit -> appendDigit(buttonType.digit)
            is ButtonType.Operation -> {
                pushNumber(_uiState.value.currentInput.toDouble())
                pushOperation(buttonType.operation)
                if (buttonType.operation == ButtonOperation.Percentage ||
                    buttonType.operation == ButtonOperation.Sign
                ) {
                    calculate()
                }
            }
        }
    }

    private fun calculate() {
        _uiState.update { state ->
            val (_, numbers, operations) = state

            while (operations.isNotEmpty()) {
                val operation = operations.pop()
                val number1 = numbers.pop()
                val result = when (operation) {
                    ButtonOperation.Percentage -> {
                        number1 * 0.01
                    }

                    ButtonOperation.Sign -> {
                        -1 * number1
                    }

                    else -> {
                        val number2 = numbers.pop()
                        when (operation) {
                            ButtonOperation.Addition -> number2 + number1
                            ButtonOperation.Subtraction -> number2 - number1
                            ButtonOperation.Multiplication -> number2 * number1
                            ButtonOperation.Division -> number2 / number1
                            else -> throw IllegalArgumentException("Invalid operator: $operation")
                        }
                    }
                }
                numbers.push(result)
            }

            state.copy(
                currentInput = String.format("%.${MAX_DECIMALS}f", numbers.peek())
                    .trimEnd('0')
                    .removeSuffix("."),
                numbers = numbers,
                operations = operations
            )
        }
    }

    private fun clear() {
        _uiState.update { CalculatorUiState() }
    }

    private fun appendDecimal() {
        _uiState.update { state ->
            val (currentInput, _, _) = state
            state.copy(
                currentInput = if ("." in currentInput) currentInput else "$currentInput."
            )
        }
    }

    private fun appendDigit(digit: String) {
        _uiState.update { state ->
            state.copy(
                currentInput = if (state.currentInput == "0") digit else state.currentInput + digit,
            )
        }
    }

    private fun pushNumber(number: Double) {
        _uiState.update { state ->
            val stack = state.numbers
            stack.push(number)
            state.copy(
                numbers = stack
            )
        }
    }

    private fun pushOperation(operation: ButtonOperation) {
        _uiState.update { state ->
            val stack = state.operations
            stack.push(operation)
            state.copy(
                operations = stack,
                currentInput = "0"
            )
        }
    }

    companion object {
        private const val MAX_DECIMALS = 6
    }
}

data class CalculatorUiState(
    val currentInput: String = "0",
    val numbers: Stack<Double> = Stack(),
    val operations: Stack<ButtonOperation> = Stack(),
    val isCleared: Boolean = true
)
