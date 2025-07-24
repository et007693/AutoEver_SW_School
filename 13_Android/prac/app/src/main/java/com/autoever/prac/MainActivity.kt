package com.autoever.prac

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.autoever.prac.ui.theme.PracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*
            5. Image, Card, State
            컴포저블로 이미지카드 만들기
            - setContent 안에 이미지카드 배치
            - 이미지 카드 안에 카드 배치
                RoundCornerShape, elevation
            - 이미지카드 안에 박스 배치
            - 드로블 폴더에 이미지 저장
            - 박스 안에 이미지 배치
            - 카드 가로 길이 지정(0.5f)
            - 카드 패딩 지정(16.df)
            - 하트 아이콘 배치
                박스 안에 박스 배치
                박스 안에 아이콘 버튼 배치
                아이콘 버튼 안에 아이콘 배치
                이미지 벡터
                틴트 화이트로
            - 하트 아이콘 클릭 동작 설정
                상태값을 변경하기 위해 변수 생성
                함수 수정
            - 이미지 카드 재사용을 위해 상태값을 외부로 빼고 매개변수화
            * */


            /*
            4. List, LazyColumn
            column으로 리스트 만들기
            - 컴포저블 만들기 위한 세팅
                스케폴드 안에 박스 배치
                박스 안에 모디파이어를 통해 스캐폴드의 이너패딩 지정
                박스 모디파이어 영역을 화면에 꽉 채움
                박스 모디파이어에 백그라운드 컬러를 지정해 영역 확인
                메인페이지 컴포저블을 만들고 박스 안에 배치
                메인페이지에 텍스트 배치
            - 컬럼과 for 문을 활용해 텍스트 리스트 만들기
            - 컬럼 모디파이어 배경색을 통해 컬럼 영역 확인
            - 컬럼 스크롤 state를 지정하여 컬럼 안쪽 영역과 바깥쪽 영역을 터치해 스크롤
            - 컬럼의 가로 영역을 꽉 채운뒤 다시 시도

            LazyColumn으로 리스트 만들기
            - 컬럼을 LazyColumn으로 수정하고 스크롤 스테이트 관련 코드 삭제
            - for문 대신 items를 사용해 리스트 생성
            - content padding과 아이템 간 간격 설정
            - 아이템으로 header와 footer 삽입
            */
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(Color.Green)
                ) {
                    MainPage()
                }
            }


            /*
            3. Box
            - 스캐폴드 유지
            - 박스 모디파이어
                배경색
                가로로 채우기
                세로는 200
                이너패딩 적용
            - 박스 안에 텍스트 배치
            - 박스 안에 박스 넣기
                모디파이어 꽉 채우기
                패딩 주기
                정렬 오른쪽 아래로
                안쪽 박스에 텍스트 넣기
            */
//            Scaffold {
//                innerPadding ->
//                Box(
//                    modifier = Modifier
//                        .padding(innerPadding)
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .background(Color.Cyan)
//                        .padding(innerPadding)
//                ) {
//                    Text("Hello World")
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(20.dp),
//                        contentAlignment = Alignment.BottomEnd
//                    ) {
//                        Text("end")
//                    }
//                }
//            }



            /*
             1. Column, Row, Text
             - 새로운 프로젝트 만들기
             - 스캐폴드 구현
             - 스캐폴드 모디파이어로 화면 채우기
             - 스캐폴드 안에 컬럼 배치
             - 텍스트 두 개 배치
             - 컬럼 모디파이어
                화면 채우기
                백그라운드 색상 변경
                이너패딩 적용
                자체 패딩(16.dp) 적용
             - 컬럼 정렬
                가로로 가운데 정렬
                세로로 항목 간 최대로 간격 띄우기
            */
//            Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
//                Column (
//                    modifier = Modifier
//                        .padding(innerPadding)
//                        .background(Color.Blue)
//                        .padding(16.dp)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text("World")
//                    Text("World")
//                }
//            }
        }
    }
}

/*
2. Composite, Preview
- 컴포저블과 프리뷰를 삭제한 후 직접 만들어본다.
- 컴포저블의 동일한 프리뷰 하나 더 만들기 - 어노테이션 사용
*/

//@Composable
//fun TestView() {
//    Text("Hello World!!")
//}
//
//@Preview(showBackground = true, name = "Hello", uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, name = "Hello", uiMode = Configuration.UI_MODE_NIGHT_MASK)
//@Composable
//fun MyTextViewPreview() {
//    TestView()
//}

//4
@Composable
fun MainPage() {
    Text("글씨")
}