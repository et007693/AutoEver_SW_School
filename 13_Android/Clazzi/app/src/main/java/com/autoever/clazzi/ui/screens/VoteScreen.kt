package com.autoever.clazzi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.autoever.clazzi.viewmodel.VoteListViewModel
import com.autoever.clazzi.viewmodel.VoteViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteScreen(
    voteId: String,
    navController: NavController,
    voteListViewModel: VoteListViewModel
) {
    val voteViewModel: VoteViewModel = viewModel()

    // 초기 데이터 로드
    LaunchedEffect(voteId) {
        voteViewModel.loadVote(voteId, voteListViewModel)
    }

    // vote state
    val vote = voteViewModel.vote.collectAsState().value

    var selectOption by remember { mutableStateOf(0) }
    var hasVoted by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "투표")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "뒤로가기")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (vote == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("친구들과 ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("서로 투표")
                        }
                        append("하며\n")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("익명")
                        }
                        append("으로 마음을 전해요")
                    }
                )

                Spacer(Modifier.height(40.dp))

                Text(
                    text = vote.title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = "투표 사진",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )

                Spacer(Modifier.height(16.dp))

                vote.voteOptions.forEachIndexed() { index, voteOption ->
                    Button(
                        onClick = {
                            selectOption = index
                        },
                        colors = ButtonDefaults.buttonColors(
                            if (selectOption == index) Color(0xFF13F8A5)
                            else Color.LightGray.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(voteOption.optionText)
                    }
                }

                Spacer(Modifier.height(40.dp))

                Button(
                    onClick = {
                        if (!hasVoted) {
                            coroutineScope.launch {
                                val user = FirebaseAuth.getInstance().currentUser
                                val uid = user?.uid ?: "0"

                                val voteId = uid
                                val selectedOption = vote.voteOptions[selectOption]

                                // 새로운 투표자를 포함한 업데이트 된 투표 옵션 생성
                                val updatedOption = selectedOption.copy( // copy 메소드는 data class 복사
                                    voters = selectedOption.voters + voteId // 객체 복사할 때 voters 필드만 바꾸어서 복사
                                )


                                // 업데이트된 투표 옵션 목록 생성 : voteOptions 여러개 중에 바뀐 항목만 바꾸어서 voteOptions 새로 생성
                                val updatedOptions = vote.voteOptions.mapIndexed{ index, voteOption ->
                                    if (index == selectOption) updatedOption else voteOption
                                }

                                val updatedVote = vote.copy(
                                    voteOptions = updatedOptions
                                )

                                voteListViewModel.setVote(updatedVote)
                                hasVoted = true
                            }
                        }
                    },

                    enabled = !hasVoted && selectOption >= 0,
                    modifier = Modifier.width(200.dp)
                ) {
                    Text("투표하기")
                }
            }
        }
    }
}