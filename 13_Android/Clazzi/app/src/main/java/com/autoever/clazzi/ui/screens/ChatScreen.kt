package com.autoever.clazzi.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController
) {
    val firestore = FirebaseFirestore.getInstance()
    val users = remember { mutableStateListOf<Pair<String, String>>() }
    val currentUserId = FirebaseAuth.getInstance().currentUser?.uid

    // firestore에서 사용자 리스트 가져오기
    LaunchedEffect(Unit) {
        firestore.collection("users")
            .get()
            .addOnSuccessListener{ result ->
                users.clear()
                for (doc in result) {
                    val uid = doc.id
                    val nickname = doc.getString("nickname") ?: uid.take(4)
                    if (uid != currentUserId) { // 자기 자신은 제외
                        users.add(Pair(uid, nickname))
                    }
                }
            }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("채팅") }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(users) { (uid, nickname) ->
                ChatItem(uid, nickname, navController, currentUserId)
            }
        }
    }
}

@Composable
fun ChatItem(
    uid: String,
    nickname: String,
    navController: NavController,
    currentUserId: String?
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // 채팅방 ID 생성
                val chatRoomId = if (currentUserId!! < uid) {
                    "${currentUserId}_$uid"
                } else {
                    "${uid}_$currentUserId"
                }
                navController.navigate("chatRoom/$chatRoomId/$uid/$nickname")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(nickname, modifier = Modifier.padding(16.dp))
    }
}