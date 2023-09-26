package com.example.u_calculator.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun CalcButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .aspectRatio(1f),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun CalcButtonPreview() {
    UCalculatorTheme {
        Column {
            CalcButton(
                text = "7",
                color = Color.LightGray
            )
            CalcButton(
                text = "4",
                color = Color.DarkGray
            )
        }
    }
}