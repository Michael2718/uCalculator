package com.example.u_calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.u_calculator.ui.theme.UCalculatorTheme
import com.example.u_calculator.ui.theme.fontFamily


@Composable
fun CalcButtonComposable(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    isWide: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .aspectRatio(if (isWide) 2f else 1f)
            .background(
                color = backgroundColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(start = if (isWide) 30.dp else 0.dp) // Crutch to align "0" and "1"
                .fillMaxWidth(),
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            textAlign = if (isWide) TextAlign.Start else TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun CalcButtonPreview() {
    UCalculatorTheme {
        Row {
//            CalcButtonComposable(
//                text = "AC",
//                color = Color(0xFFa5a5a5),
//                textColor = Color.Black,
//                isWide = false,
//                onClick = {},
//                modifier = Modifier
//                    .padding(8.dp)
//                    .weight(1f)
//            )
//            CalcButtonComposable(
//                text = "+/-",
//                color = Color(0xFFa5a5a5),
//                textColor = Color.Black,
//                isWide = false,
//                onClick = {},
//                modifier = Modifier
//                    .padding(8.dp)
//                    .weight(1f)
//            )
        }
    }
}