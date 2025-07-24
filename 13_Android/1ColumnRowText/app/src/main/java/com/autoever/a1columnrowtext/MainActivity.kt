package com.autoever.a1columnrowtext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Scaffold = 앱 화면의 기본 구조(상단 바, 하단 바, 플로팅 버튼 등)를 쉽게 배치할 수 있는 틀
            Scaffold { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
//                        .padding(16.dp)
                        .background(Color.Green)
                        .fillMaxSize()
                        // 순서에 따라 적용 방식이 달라짐
                        .padding(16.dp),
                    // 수평 정렬
                    horizontalAlignment = Alignment.CenterHorizontally,
                    // 수직 정렬
//                    verticalArrangement = Arrangement.Center
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
//                    verticalArrangement = Arrangement.SpaceBetween
                    verticalArrangement = Arrangement.SpaceAround
//                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "Hello",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    )
                    Text("World")
                    Text("World2")
                }
            }
        }

            // Scaffold = 앱 화면의 기본 구조(상단 바, 하단 바, 플로팅 버튼 등)를 쉽게 배치할 수 있는 틀
//            Scaffold { innerPadding ->
//                Column (
//                    // 컴포넌트들의 속성 지정
//                    modifier = Modifier
//                        .padding(innerPadding)
//                        .padding(16.dp)
//                ) {
//                    Text(
//                        "Hello",
//                        // 단독 컴포넌트 속성
//                        modifier = Modifier
//                            .padding(bottom = 16.dp)
//                    )
//                    Button(onClick = {/*TODO*/}) { }
//
//                    Text("World")
//
//                    // 컴포넌트 간 공백
//                    Spacer(modifier = Modifier.height(32.dp))
//                    Text("World")
//                    Text("World")
//                }
//            }
//        }

            // 수평 배치
//            Row {
//                Text("Hello")
//
//                Button(onClick = {/*TODO*/}) { }
//                Text("World")
//                Text("World")
//            }

            // 수직 배치
//            Column {
//                Text("Hello")
//                Text("World")
//                Text("World")
//            }
    }
}
