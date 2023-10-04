package com.example.u_calculator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.u_calculator.data.Buttons
import com.example.u_calculator.ui.screens.HomeScreen
import com.example.u_calculator.ui.theme.UCalculatorTheme

@Composable
fun UCalculatorApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val buttons = Buttons.value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            HomeScreen(
                uiState = uiState,
                buttons = buttons,
                onButtonClick = { buttonType ->
                    viewModel.onButtonClick(buttonType)
                },
                modifier = modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 40.dp)
            )
        }

        WindowWidthSizeClass.Medium -> {
            HomeScreen(
                uiState = uiState,
                buttons = buttons,
                onButtonClick = { buttonType ->
                    viewModel.onButtonClick(buttonType)
                },
                modifier = modifier
                    .padding(start = 120.dp, end = 120.dp, bottom = 40.dp)
            )
        }

        WindowWidthSizeClass.Expanded -> {
            HomeScreen(
                uiState = uiState,
                buttons = buttons,
                onButtonClick = { buttonType ->
                    viewModel.onButtonClick(buttonType)
                },
                modifier = modifier
                    .padding(start = 260.dp, end = 260.dp, bottom = 40.dp)
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun UCalculatorAppCompactPreview() {
    UCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UCalculatorApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun UCalculatorAppMediumPreview() {
    UCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UCalculatorApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun UCalculatorAppExpandedPreview() {
    UCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UCalculatorApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
    }
}
