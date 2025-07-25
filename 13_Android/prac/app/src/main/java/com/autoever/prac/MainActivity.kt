package com.autoever.prac

import android.content.res.Configuration
import android.graphics.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.autoever.prac.ui.theme.PracTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val movieList = remember() {
                mutableStateListOf(
                    Movie("인사이드 아웃", R.drawable.poster),
                    Movie("라라랜드", R.drawable.poster2),
                    Movie("범죄도시", R.drawable.poster3),
                    Movie("뷰티 인사이드", R.drawable.poster4),
                )
            }

            Scaffold() {innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(top = 16.dp)
                        .fillMaxSize(),
                ) {
                    itemsIndexed(movieList) { index, movie ->
                        MoviePoster(movie.isFavorite, movie.imageRes) { favorite ->
                            movieList[index] = movie.copy(isFavorite = favorite)
                        }
                    }
                }
            }

            /*
            5. Image, Card, State
            컴포저블로 이미지카드 만들기
            - setContent 안에 이미지카드 배치
            - 이미지 카드 안에 카드 배치
                RoundCornerShape, elevation
            - 이미지카드 안에 박스 배치
            - 드로블 폴더에 이미지 저장
            - 박스 안에 이미지 배치
                이미지 페인터 속성 - 페인터 리소스 id
                contentScale, crop
            - 카드 가로 길이 지정(0.5f)
            - 카드 패딩 지정(16.df)
            - 하트 아이콘 배치
                박스 안에 박스 배치
                박스 안에 아이콘 버튼 배치
                아이콘 버튼 안에 아이콘 배치
                이미지 벡터
                틴트 화이트로
            - 하트 아이콘 클릭 동작 설정
                상태값을 변경하기 위해 변수 생성(var isFavorite: Boolean
                함수 수정(onClick = {isFavorite.value = !isFavorite.value}
                remember -> rememberSaveable로 수정
            - 이미지 카드 재사용을 위해 상태값을 외부로 빼고 매개변수 입력
            -  이미지카드 호출할 때 인자 할당하는 코드로 수정
            - 상태값도 setContent로 이동
            - 아이콘 버튼 onclick에서 바로 변경 못하므로 콜백함수 추가
            - 온클릭 안에서 setcontent 이미지 카드 호출하는 부분을 콜백 처리
            - 이미지 카드 모디파이어도 외부에서 할당하도록 수정
            - 카드에 있던 모디파이어를 이미지카드 호출하는 부분으로 이동
            * */
//            var isFavorite by rememberSaveable { mutableStateOf(false) }
//
//            Scaffold(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) { innerPadding ->
//                Box(
//                    modifier = Modifier
//                        .padding(innerPadding)
//                        .padding(16.dp)
//                ) {
//                    ImageCard(isFavorite) { favorite ->
//                        isFavorite = favorite
//                    }
//
//                }
//            }


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
//            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                Box(
//                    modifier = Modifier
//                        .padding(innerPadding)
//                        .fillMaxSize()
//                        .background(Color.Green)
//                ) {
//                    MainPage()
//                }
//            }


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

data class Movie (
    val title:String,
    val imageRes:Int,
    val isFavorite: Boolean=false
)

@Composable
fun MoviePoster(
    isFavorite: Boolean,
    imageRes: Int,
    onTabFavorite: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(500.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box() {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = imageRes),
                contentScale = ContentScale.Crop,
                contentDescription = "Poster"
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(
                    onClick = {onTabFavorite(!isFavorite)}
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Poster",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

// 5
@Composable
fun ImageCard(
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit
) {
//    val isFavorite by rememberSaveable { mutableStateOf(false) }
    Card (
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(200.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.poster),
                contentScale = ContentScale.Crop,
                contentDescription = "Poster"
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(
//                    onClick = {isFavorite.value = !isFavorite.value}
                    onClick = {onTabFavorite(!isFavorite)}
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
//                        tint = Color.White
                    )
                }
            }
        }
    }
}

// 4
@Composable
fun MainPage() {
    // 화면에 보이는 항목만 렌더링하는 세로 스크롤 리스트
    LazyColumn (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text("Header")
        }
        items(50) { i ->
            Text("$i 번째 행")
        }
        item {
            Text("Footer")
        }
    }
    
    // 스크롤 객체
//    val scrollState = rememberScrollState()

    // Column으로 콘텐츠 생성
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState),
//            .background(Color.Yellow)
//    ) {
//        for (i in 1 .. 50) {
//            Text("$i 번째 행")
//        }
//    }

}

/*
2. Composite, Preview
- 컴포저블과 프리뷰를 삭제한 후 직접 만들어본다.
- 컴포저블의 동일한 프리뷰 하나 더 만들기 - 어노테이션 사용
*/

@Composable
fun TestView() {
    Text("Hello World!!")
}

@Preview(showBackground = true, name = "Hello", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, name = "Hello", uiMode = Configuration.UI_MODE_NIGHT_MASK)
@Composable
fun MyTextViewPreview() {
    TestView()
}