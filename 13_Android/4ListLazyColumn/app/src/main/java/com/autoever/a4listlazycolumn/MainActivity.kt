package com.autoever.a4listlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.autoever.a4listlazycolumn.ui.theme._4ListLazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4ListLazyColumnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        MainPage()
                    }
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    // LazyColumn 사용 시 scrollstate 필요 없음
//    val scrollState = rememberScrollState()
//    Column (
    // 스크롤 가능한 세로 리스트를 효율적으로 그려주는 Composable
    LazyColumn (
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize(),
//            .verticalScroll(scrollState)
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//        for(i in 1 .. 50) {
//            Text("Hello MainPage $i")
//        items(50) { index ->
//            Text("Hello MainPage $index")
//        }

        item {
            Text("Header")
        }

        items(50) { i ->
            Text("Hello World")
        }
        item {
            Text("Fotter")
        }
    }
}
@Composable
fun MyRow() {
    Row {
        Text(text = "이것은")
        Spacer(modifier = Modifier.width(32.dp))
        Text(text = "로우입니다.")
    }
}