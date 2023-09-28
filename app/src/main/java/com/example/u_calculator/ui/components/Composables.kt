package com.example.u_calculator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun CalcButton(
    text: String,
    color: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,//.fillMaxSize(),
//            .size(64.dp)
//            .aspectRatio(1f)
//            .fillMaxSize()
//            .requiredSize(88.dp),
//            .fillMaxSize(),
//            .aspectRatio(1f),
//            .fillMaxSize(),
//            .aspectRatio(1f),
//            .requiredSize(64.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        )
    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
//            softWrap = false
        )
    }
}

@Preview
@Composable
fun CalcButtonPreview() {
    UCalculatorTheme {
        Column {
//            CalcButton(
//                text = "7",
//                color = Color.LightGray
//            )
//            CalcButton(
//                text = "4",
//                color = Color.DarkGray
//            )
        }
    }
}