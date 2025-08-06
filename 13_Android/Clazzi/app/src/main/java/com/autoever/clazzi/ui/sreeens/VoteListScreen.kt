package com.autoever.clazzi.ui.sreeens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.autoever.clazzi.model.Vote
import com.autoever.clazzi.model.VoteOption
import com.autoever.clazzi.ui.theme.ClazziTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteListScreen(
    navController: NavController,
    voteList: List<Vote>,
    onVoteClicked: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("투표 목록") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("createVote")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "투표 만들기")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(voteList) { vote ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            onVoteClicked(vote.id)
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(vote.title)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VoteListScreenPreview() {
    ClazziTheme {
        VoteListScreen(
            navController = NavController(LocalContext.current),
            voteList = arrayListOf(),
            onVoteClicked = {},
        )
    }
}
