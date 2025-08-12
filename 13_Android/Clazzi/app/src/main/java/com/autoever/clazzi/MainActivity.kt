package com.autoever.clazzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.autoever.clazzi.repository.FirebaseVoteRepository
import com.autoever.clazzi.repository.RestApiVoteRepository
import com.autoever.clazzi.repository.network.ApiClient
import com.autoever.clazzi.ui.screens.AuthScreen
import com.autoever.clazzi.ui.screens.ChatScreen
import com.autoever.clazzi.ui.screens.CreateVoteScreen
import com.autoever.clazzi.ui.screens.VoteListScreen
import com.autoever.clazzi.ui.screens.VoteScreen
import com.autoever.clazzi.ui.theme.ClazziTheme
import com.autoever.clazzi.ui.screens.MyPageScreen
import com.autoever.clazzi.viewmodel.VoteListViewModel
import com.autoever.clazzi.viewmodel.VoteListViewModelFactory
import com.autoever.clazzi.viewmodel.VoteViewModel
import com.autoever.clazzi.viewmodel.VoteViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClazziTheme {
                val navController = rememberNavController()
                val isLoggedIn = FirebaseAuth.getInstance().currentUser != null
                val repo = FirebaseVoteRepository() // 파이어베이스 연동
//                val repo = RestApiVoteRepository(ApiClient.voteApiService) // restAPI 연동
                val voteViewModel: VoteViewModel = viewModel(
                    factory = VoteViewModelFactory(repo)
                )
                val voteListViewModel: VoteListViewModel = viewModel(
                    factory = VoteListViewModelFactory(repo)
                )

                NavHost(
                    navController = navController,
                    startDestination = if (isLoggedIn) "main" else "auth"
                ) {
                    composable("auth") {
                        AuthScreen(navController = navController)
                    }

                    composable("main") {
                        MainScreen(voteListViewModel, navController)
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
                            voteViewModel = voteViewModel,
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

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object VoteList: BottomNavItem("voteList", Icons.AutoMirrored.Filled.List, "투표")
    object Chat: BottomNavItem("chat", Icons.AutoMirrored.Filled.List, "채팅")
    object MyPage: BottomNavItem("myPage", Icons.AutoMirrored.Filled.List, "마이페이지")
}

@Composable
fun MainScreen(
    voteListViewModel: VoteListViewModel, rootNavController: NavController
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "voteList",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.VoteList.route) {
                VoteListScreen(
                    navController = navController,
                    viewModel = voteListViewModel,
                    onVoteClicked = { voteId ->
                        navController.navigate("vote/$voteId")
                    }
                )
            }
            composable(BottomNavItem.Chat.route){
                ChatScreen()
            }

            composable(BottomNavItem.MyPage.route) {
                MyPageScreen(navController = navController)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.VoteList,
        BottomNavItem.Chat,
        BottomNavItem.MyPage
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}