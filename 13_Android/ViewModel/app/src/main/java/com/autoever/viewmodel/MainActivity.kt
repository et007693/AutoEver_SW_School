package com.autoever.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.State
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
//    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            var text = remember { mutableStateOf("Hello") }
            val viewModel: MainViewModel = viewModel()
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {
                Text(viewModel.text.value)
                Button(
                    onClick = {
                        viewModel.changeText()
                    }
                ) {
                    Text("변경")
                }
            }
        }
    }
}


class MainViewModel : ViewModel() {
    private val _text = mutableStateOf("Hello")
    val text : State<String> = _text

    fun changeText() {
        if (_text.value.equals("Hello")) {
            _text.value = "World"

        } else {
            _text.value = "Hello"
        }
    }
}