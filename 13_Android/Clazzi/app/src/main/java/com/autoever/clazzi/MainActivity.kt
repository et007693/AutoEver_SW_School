package com.autoever.clazzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.autoever.clazzi.model.Vote
import com.autoever.clazzi.model.VoteOption
import com.autoever.clazzi.ui.sreeens.CreateVoteScreen
import com.autoever.clazzi.ui.sreeens.VoteListScreen
import com.autoever.clazzi.ui.sreeens.VoteScreen
import com.autoever.clazzi.ui.theme.ClazziTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClazziTheme {
                val navController = rememberNavController()
                val voteList = remember {
                    mutableStateListOf(
                        Vote(
                            id = "1", title = "오늘 점심 뭐 먹을까요?", voteOptions = listOf(
                                VoteOption(id = "1", optionText = "삼겹살"),
                                VoteOption(id = "2", optionText = "치킨"),
                                VoteOption(id = "3", optionText = "피자"),
                            )
                        ),
                        Vote(
                            id = "2", title = "우리 반에서 제일 잘 생긴 사람은?", voteOptions = listOf(
                                VoteOption(id = "1", optionText = "김한수"),
                                VoteOption(id = "2", optionText = "박명수"),
                                VoteOption(id = "3", optionText = "유재석"),
                            )
                        ),
                        Vote(
                            id = "3", title = "서핑 같이 가고 싶은 사람은?", voteOptions = listOf(
                                VoteOption(id = "1", optionText = "정준하"),
                                VoteOption(id = "2", optionText = "하하"),
                            )
                        )
                    )
                }

                NavHost(
                    navController = navController,
                    startDestination = "voteList"
                ) {
                    composable("voteList") {
                        VoteListScreen(
                            navController = navController,
                            voteList = voteList,
                            onVoteClicked = { voteId ->
                                navController.navigate("vote/$voteId")
                            }
                        )
                    }
                    composable("vote/{voteId}") { backStackEntry ->
                        val voteId = backStackEntry.arguments?.getString("voteId") ?: "1"
                        VoteScreen(
                            vote = voteList.first{ vote ->
                                vote.id == voteId
                            },
                            navController = navController
                        )
                    }

                    composable("createVote") {
                        CreateVoteScreen(
                            onVoteCreate = { vote ->
                                navController.popBackStack()
                                voteList.add(vote)
                            }
                        )
                    }
                }
            }
        }
    }
}

