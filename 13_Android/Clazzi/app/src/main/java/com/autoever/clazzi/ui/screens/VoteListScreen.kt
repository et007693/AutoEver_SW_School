package com.autoever.clazzi.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.autoever.clazzi.R
import com.autoever.clazzi.model.Vote
import com.autoever.clazzi.ui.theme.ClazziTheme
import com.autoever.clazzi.viewmodel.VoteListViewModel
import com.autoever.clazzi.util.formatDate
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteListScreen(
    navController: NavController,
    viewModel: VoteListViewModel,
    onVoteClicked: (String) -> Unit,
    parentNavController: NavController
) {
    val voteList by viewModel.voteList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.vote_list_title)) },
                actions = {
                    IconButton(
                        onClick = {parentNavController.navigate("myPage")}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "마이페이지"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    parentNavController.navigate("createVote")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "투표 만들기")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
//                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(voteList) { vote ->
                VoteItem(vote) {
                    onVoteClicked(it)
                }
            }
        }
    }
}

@Composable
fun VoteItem(
    vote: Vote, onVoteClicked: (String) -> Unit
) {
    val user = FirebaseAuth.getInstance().currentUser
    val currentUserId = user?.uid ?: "0"

    // hasVoted 상태 : 사용자가 투표했는지 확인
    var hasVoted by remember { mutableStateOf(false) }

    // vote 데이터가 로드된 후 haxVoted 초기화
    LaunchedEffect(vote) {
        hasVoted = vote.voteOptions.any { option ->
            option.voters.contains(currentUserId)
        }
    }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onVoteClicked(vote.id)
            }
    ) {
        LaunchedEffect(vote) {
            hasVoted = vote.voteOptions.any { option ->
                option.voters.contains(currentUserId)
            }
        }

        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(vote.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "생성일: ${formatDate(vote.createAt)}"
                )
                Text(
                    text = "항목 갯수: ${vote.optionCount}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            // 투표 여부
            Text(if (hasVoted) "투표 완료" else "투표 미완료")
        }
    }
}