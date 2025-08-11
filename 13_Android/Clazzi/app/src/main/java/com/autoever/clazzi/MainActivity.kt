package com.autoever.clazzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.autoever.clazzi.ui.screens.AuthScreen
import com.autoever.clazzi.ui.screens.CreateVoteScreen
import com.autoever.clazzi.ui.screens.VoteListScreen
import com.autoever.clazzi.ui.screens.VoteScreen
import com.autoever.clazzi.ui.theme.ClazziTheme
import com.autoever.clazzi.ui.screens.MyPageScreen
import com.autoever.clazzi.viewmodel.VoteListViewModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClazziTheme {
                val navController = rememberNavController()
                val voteListViewModel = viewModel<VoteListViewModel>()
                val isLoggedIn = FirebaseAuth.getInstance().currentUser != null

                NavHost(
                    navController = navController,
                    startDestination = if (isLoggedIn) "voteList" else "auth"
                ) {
                    composable("MyPage") {
                        MyPageScreen(navController = navController)
                    }
                    composable("auth") {
                        AuthScreen(navController = navController)
                    }
                    composable("voteList") {
                        VoteListScreen(
                            navController = navController,
                            viewModel = voteListViewModel,
                            onVoteClicked = { voteId ->
                                navController.navigate("vote/$voteId")
                            }
                        )
                    }
                    composable(
                        "vote/{voteId}",
                        deepLinks = listOf(
                            navDeepLink { uriPattern = "clazzi://vote/{voteId}" },
                            navDeepLink { uriPattern = "https://clazzi.web.app/vote/{voteId}" }
                        )
                    ) { backStackEntry ->
                        val voteId = backStackEntry.arguments?.getString("voteId") ?: "1"
                        VoteScreen(
                            voteId = voteId,
                            navController = navController,
                            voteListViewModel = voteListViewModel
                        )
                        /*if (vote != null) {
                            VoteScreen(
                                vote = vote,
                                navController = navController,
                                voteListViewModel = voteListViewModel
                            )
                        } else {
                            val context = LocalContext.current
                            Toast.makeText(context, "해당 투표가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }*/
                    }
                    composable("createVote") {
                        CreateVoteScreen(
                            navController = navController,
                            viewModel = voteListViewModel
                        )
                    }
                }
            }
        }
    }
}

