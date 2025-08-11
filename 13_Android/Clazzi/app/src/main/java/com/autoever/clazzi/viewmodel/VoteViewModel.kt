package com.autoever.clazzi.viewmodel

import com.autoever.clazzi.model.Vote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope

class VoteViewModel {
    private val _vote = MutableStateFlow<Vote?>(null)
    val vote: StateFlow<Vote?> = _vote

    fun loadVote(voteId: String, voteListViewModel: VoteListViewModel) {
        viewModelScope.launch {
            _vote.value = voteListViewModel.getVoteById(voteId)
        }
    }
}