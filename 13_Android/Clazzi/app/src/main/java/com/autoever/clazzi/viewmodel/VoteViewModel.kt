package com.autoever.clazzi.viewmodel

import androidx.lifecycle.ViewModel
import com.autoever.clazzi.model.Vote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class VoteViewModel : ViewModel() {
    private val _vote = MutableStateFlow<Vote?>(null)
    val vote: StateFlow<Vote?> = _vote

    fun loadVote(voteId: String, voteListViewModel: VoteListViewModel) {
        Firebase.firestore.collection("votes").document(voteId)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    _vote.value = snapshot.toObject(Vote::class.java)
                }
            }
    }
}