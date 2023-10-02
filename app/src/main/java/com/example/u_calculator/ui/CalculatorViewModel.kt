package com.example.u_calculator.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.util.Stack

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())

    val uiState: StateFlow<CalculatorUiState> = _uiState

    fun onButtonClick(buttonType: ButtonType) {
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
                if (buttonType.operation == ButtonOperation.Percentage) {
                    calculate()
                }
//                _uiState.update { state ->
//                    state.copy(
//                        currentInput = "0"
//                    )
//                }
            }
        }
    }

    private fun calculate() {
        _uiState.update { state ->
            val (_, numbers, operations) = state

            while (operations.isNotEmpty()) {
                val operation = operations.pop()
                val number1 = numbers.pop()
                val result = if (operation == ButtonOperation.Percentage) {
                    number1 * 0.01
                } else {
                    val number2 = numbers.pop()
                    when (operation) {
                        ButtonOperation.Addition -> number2 + number1
                        ButtonOperation.Subtraction -> number2 - number1
                        ButtonOperation.Multiplication -> number2 * number1
                        ButtonOperation.Division -> number2 / number1
                        else -> throw IllegalArgumentException("Invalid operator: $operation")
                    }
                }
                numbers.push(result)
            }

            state.copy(
                currentInput = numbers.peek().toString(),
                numbers = numbers,
                operations = operations
            )
        }
    }

    private fun clear() {
        _uiState.update { CalculatorUiState() }
    }

    private fun appendDecimal() { // TODO: Implement appending decimal point
//        _uiState.update { state ->
//            val (operand1, operand2, operation) = state
//            state.copy(
//                operand1 = if (operation == null && "." !in operand1) "$operand1." else operand1,
//                operand2 = if (operation != null && "." !in operand2) "$operand2." else operand2
//            )
//        }
    }

    private fun appendDigit(digit: String) {
        _uiState.update { state ->
            state.copy(
                currentInput = if (state.currentInput == "0") digit else state.currentInput + digit,
                // currentInput = if (state.currentInput == "0" || state.currentInput.toDouble() == state.numbers.peek()) digit else state.currentInput + digit,
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
            if (state.currentInput == "0") stack.pop()
            stack.push(operation)
            state.copy(
                operations = stack,
                currentInput = "0"
            )
        }
    }
}

data class CalculatorUiState(
    val currentInput: String = "0",
    val numbers: Stack<Double> = Stack(),
    val operations: Stack<ButtonOperation> = Stack()
)
