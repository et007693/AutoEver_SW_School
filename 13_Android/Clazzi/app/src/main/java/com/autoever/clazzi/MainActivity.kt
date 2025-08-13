package com.autoever.clazzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.autoever.clazzi.repository.FirebaseVoteRepository
import com.autoever.clazzi.repository.RestApiVoteRepository
import com.autoever.clazzi.ui.screens.AuthScreen
import com.autoever.clazzi.ui.screens.ChatRoomScreen
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
import com.google.firebase.firestore.FirebaseFirestore

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
                val auth = FirebaseAuth.getInstance()

                LaunchedEffect(auth.currentUser) {
                    auth.currentUser?.let { user ->
                        val nickname = user.uid.take(4)
                        FirebaseFirestore.getInstance().collection("users")
                            .document(user.uid)
                            .set(mapOf("nickname" to nickname))
                    }
                }

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
                    }
                    composable("createVote") {
                        CreateVoteScreen(
                            navController = navController,
                            viewModel = voteListViewModel
                        )
                    }

                    composable("myPage") {
                        MyPageScreen(
                            navController = navController
                        )
                    }

                    composable("chatRoom/{chatRoomId}/{otherUserId}/{otherNickname}") { backStackEntry ->
                        val chatRoomId = backStackEntry.arguments?.getString("chatRoomId") ?: ""
                        val otherUserId = backStackEntry.arguments?.getString("otherUserId") ?: ""
                        val otherNickname = backStackEntry.arguments?.getString("otherNickname") ?: ""
                        ChatRoomScreen(
                            chatRoomId = chatRoomId,
                            otherUserId = otherUserId,
                            otherNickname = otherNickname
                        )
                    }
                }
            }
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object VoteList: BottomNavItem("voteList", Icons.AutoMirrored.Filled.List, "투표")
    object Chat: BottomNavItem("chat", Icons.Filled.ChatBubble, "채팅")
    object MyPage: BottomNavItem("myPage", Icons.Default.Person, "마이페이지")
}

@Composable
fun MainScreen(
    voteListViewModel: VoteListViewModel,
    parentNavController: NavController
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
                    parentNavController = parentNavController,
                    viewModel = voteListViewModel,
                    onVoteClicked = { voteId ->
                        parentNavController.navigate("vote/$voteId")
                    },
                )
            }
            composable(BottomNavItem.Chat.route){
                ChatScreen(parentNavController)
            }

            composable(BottomNavItem.MyPage.route) {
                MyPageScreen(navController = parentNavController)
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