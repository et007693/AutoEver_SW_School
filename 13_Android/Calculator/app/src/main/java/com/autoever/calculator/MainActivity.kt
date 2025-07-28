package com.autoever.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CalculatorViewModel = viewModel()

            val buttons = listOf(
                "C", "/", "*", "del",
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "=",
                "0",
            )

            Scaffold() { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                ) {
                    // 상단 영역
                    Box (
                        modifier = Modifier
                            .weight(3f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.input.value,
                            fontSize = 32.sp
                        )
                    }

                    // 하단 영역
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        val normalButtons = buttons.filter { it != "0" }

                        items(normalButtons) { label ->
                            Button(
                                onClick = {viewModel.onButtonClick(label)},
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .aspectRatio(1f)
                            ) {
                                Text(text = label)
                            }
                        }

                        item(span = { GridItemSpan(4) }) {
                            Button(
                                onClick = { viewModel.onButtonClick("0") },
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(5f)
                            ) {
                                Text(text = "0")
                            }
                        }
                    }
                }
            }
        }
    }
}
class CalculatorViewModel : ViewModel() {
    private var _display = mutableStateOf("")
    val input: State<String> = _display

    private var inputA = ""
    private var inputB = ""
    private var operator = ""

    fun onButtonClick(label: String) {
        when(label) {
            "C" -> {
                inputA = ""
                inputB = ""
                operator = ""
                _display.value = ""
            }
            "/" -> {
                if (inputB.isEmpty()) return
                operator = "/"
                _display.value = inputA + operator + inputB
            }
            "*" -> {
                operator = "*"
                _display.value = inputA + operator + inputB
            }
            "+" -> {
                operator = "+"
                _display.value = inputA + operator + inputB

            }
            "-" -> {
                operator = "-"
                _display.value = inputA + operator + inputB

            }
            "del" -> {
                if (inputB.isNotEmpty()) {
                    inputB = inputB.dropLast(1)
                } else if (operator.isNotEmpty()) {
                    operator = ""
                } else if (inputA.isNotEmpty()) {
                    inputA = inputA.dropLast(1)
                }
                _display.value = inputA + operator + inputB
            }
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                if (operator.isEmpty()) {
                    inputA += label
                    _display.value = inputA + operator + inputB
                } else {
                    inputB += label
                    _display.value = inputA + operator + inputB
                }
            }
            "=" -> {
                if (inputA.isNotEmpty() && inputB.isNotEmpty() && operator.isNotEmpty()) {
                    when (operator) {
                        "+" -> {
                            _display.value = (inputA.toInt() + inputB.toInt()).toString()
                        }

                        "-" -> {
                            _display.value = (inputA.toInt() - inputB.toInt()).toString()
                        }

                        "*" -> {
                            _display.value = (inputA.toInt() * inputB.toInt()).toString()
                        }

                        "/" -> {
                            _display.value = (inputA.toInt() / inputB.toInt()).toString()
                        }
                    }
                    inputA = _display.value
                    inputB = ""
                    operator = ""
                } else {
                    return
                }
            }
        }
    }
}
