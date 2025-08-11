package com.autoever.clazzi.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.autoever.clazzi.model.Vote
import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID

class VoteListViewModel:ViewModel() {
    val db = Firebase.firestore
    private val _voteList = MutableStateFlow<List<Vote>>(emptyList())
    val voteList: StateFlow<List<Vote>> = _voteList

    init {
        // 뷰모델 초기화 시 실시간 리스너 설정
        db.collection("votes")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .addSnapshotListener() { snapshot, error ->
                if (error != null) {
                    Log.e("Firestore", "Error getting votes", error)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    _voteList.value = snapshot.toObjects(Vote::class.java)
                }
            }
    }

    // ID로 특정 투표를 가져오는 메서드
    fun getVoteById(voteId: String): Vote? {
        return _voteList.value.find {it.id == voteId }
    }

    // 새로운 투표를 추가하는 메서드
    fun addVote(vote: Vote, context: Context, imageUri: Uri) {
        viewModelScope.launch {
            try {
                val storageRef = FirebaseStorage.getInstance().reference
                val imageRef = storageRef.child("images/${UUID.randomUUID()}.jpg")

                // 이미지 업로드
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val uploadType = inputStream?.let { imageRef.putStream(it).await() }

                // 다운로드 URL 가져오기
                val downloadUrl = uploadType?.storage?.downloadUrl?.await()

                // Firestore에 업로드할 데이터 구성
                val voteMap = hashMapOf(
                    "id" to vote.id,
                    "title" to vote.title,
                    "imageUrl" to downloadUrl,
                    "createdAt" to FieldValue.serverTimestamp(),
                    "voteOptions" to vote.voteOptions.map {
                        hashMapOf(
                            "id" to it.id,
                            "optionText" to it.optionText,
                        )
                    }
                )
                db.collection("votes")
                    .document(vote.id)
                    .set(voteMap)
                    .await()
            } catch (e: Exception) {
                Log.e("Firestore", "Error adding vote", e)
            }
        }
    }

    fun setVote(vote:Vote) {
        viewModelScope.launch {
            try {
                db.collection("votes")
                    .document(vote.id)
                    .set(vote)
                    .await()
                Log.d("Firestore", "투표가 성공적으로 되었습니다.")
            } catch (e: Exception) {
                Log.e("Firestore", "투표 업데이트 중 오류가 발생했습니다.", e)
            }
        }
    }
}