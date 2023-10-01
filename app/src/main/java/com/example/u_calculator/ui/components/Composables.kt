package com.example.u_calculator.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun CalcButtonComposable(
    text: String,
    color: Color,
    textColor: Color,
    isWide: Boolean,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onClick(text)
        },
        modifier = modifier
            .aspectRatio(if (isWide) 2f else 1f),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        )
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(start = if (isWide) 10.dp else 0.dp) // Crutch to align "0" and "1"
                .fillMaxWidth(),
            textAlign = if (isWide) TextAlign.Start else TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview
@Composable
fun CalcButtonPreview() {
    UCalculatorTheme {
        Row {
            CalcButtonComposable(
                text = "AC",
                color = Color(0xFFa5a5a5),
                textColor = Color.Black,
                isWide = false,
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            CalcButtonComposable(
                text = "+/-",
                color = Color(0xFFa5a5a5),
                textColor = Color.Black,
                isWide = false,
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
        }
    }
}