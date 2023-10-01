package com.example.u_calculator.ui

import androidx.compose.ui.graphics.Color

object Buttons {
    val value = listOf(
        listOf(
            CalcButton(
                value = "AC",
                type = ButtonType.Clear,
                color = Color(0xFFa5a5a5),
                textColor = Color.Black
            ),
            CalcButton(
                value = "+/-",
                type = ButtonType.Clear, // TODO: Change sign
                color = Color(0xFFa5a5a5),
                textColor = Color.Black
            ),
            CalcButton(
                value = "%",
                type = ButtonType.Operation(ButtonOperation.Percentage),
                color = Color(0xFFa5a5a5),
                textColor = Color.Black
            ),
            CalcButton(
                value = "/",
                type = ButtonType.Operation(ButtonOperation.Division),
                color = Color(0xFFff9f0a),
            )
        ),
        listOf(
            CalcButton(
                value = "7",
                type = ButtonType.Digit("7"),
            ),
            CalcButton(
                value = "8",
                type = ButtonType.Digit("8"),
            ),
            CalcButton(
                value = "9",
                type = ButtonType.Digit("9"),
            ),
            CalcButton(
                value = "*",
                type = ButtonType.Operation(ButtonOperation.Multiplication),
                color = Color(0xFFff9f0a),
            )
        ),
        listOf(
            CalcButton(
                value = "4",
                type = ButtonType.Digit("4"),
            ),
            CalcButton(
                value = "5",
                type = ButtonType.Digit("5"),
            ),
            CalcButton(
                value = "6",
                type = ButtonType.Digit("6"),
            ),
            CalcButton(
                value = "-",
                type = ButtonType.Operation(ButtonOperation.Subtraction),
                color = Color(0xFFff9f0a),
            )
        ),
        listOf(
            CalcButton(
                value = "1",
                type = ButtonType.Digit("1"),
            ),
            CalcButton(
                value = "2",
                type = ButtonType.Digit("2"),
            ),
            CalcButton(
                value = "3",
                type = ButtonType.Digit("3"),
            ),
            CalcButton(
                value = "+",
                type = ButtonType.Operation(ButtonOperation.Addition),
                color = Color(0xFFff9f0a),
            )
        ),
        listOf(
            CalcButton(
                value = "0",
                type = ButtonType.Digit("0"),
                isWide = true
            ),
            CalcButton(
                value = ".",
                type = ButtonType.Decimal,
            ),
            CalcButton(
                value = "=",
                type = ButtonType.Calculate,
                color = Color(0xFFff9f0a),
            )
        )
    )
}