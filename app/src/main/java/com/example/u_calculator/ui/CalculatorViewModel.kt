package com.example.u_calculator.ui

import androidx.lifecycle.ViewModel
import com.example.u_calculator.data.ButtonOperation
import com.example.u_calculator.data.ButtonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.mariuszgromada.math.mxparser.Expression

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
            val (_, exp, _) = state

            val result = Expression(exp).calculate()

            state.copy(
                currentInput = String.format("%.${MAX_DECIMALS}f", result)
                    .trimEnd('0')
                    .removeSuffix("."),
                expression = ""
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
            state.copy(
                expression = state.expression + number.toString()
            )
        }
    }

    private fun pushOperation(operation: ButtonOperation) {
        _uiState.update { state ->
            state.copy(
                currentInput = "0",
                expression = when (operation) {
                    ButtonOperation.Sign -> "-" + state.expression
                    ButtonOperation.Percentage -> state.expression + "/100"
                    else -> state.expression + operation.value
                }
            )
        }
    }

    companion object {
        private const val MAX_DECIMALS = 6
    }
}

data class CalculatorUiState(
    val currentInput: String = "0",
    val expression: String = "",
    val isCleared: Boolean = true
)
