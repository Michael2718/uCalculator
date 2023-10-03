package com.example.u_calculator.ui

object Buttons {
    val value = listOf(
        listOf(
            CalcButton(
                value = "AC",
                type = ButtonType.Clear,
                colorType = ColorType.Tertiary
            ),
            CalcButton(
                value = "+/-",
                type = ButtonType.Operation(ButtonOperation.Sign),
                colorType = ColorType.Tertiary
            ),
            CalcButton(
                value = "%",
                type = ButtonType.Operation(ButtonOperation.Percentage),
                colorType = ColorType.Tertiary
            ),
            CalcButton(
                value = "÷",
                type = ButtonType.Operation(ButtonOperation.Division),
                colorType = ColorType.Primary
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
                value = "×",
                type = ButtonType.Operation(ButtonOperation.Multiplication),
                colorType = ColorType.Primary
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
                value = "–",
                type = ButtonType.Operation(ButtonOperation.Subtraction),
                colorType = ColorType.Primary
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
                colorType = ColorType.Primary
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
                colorType = ColorType.Primary
            )
        )
    )
}