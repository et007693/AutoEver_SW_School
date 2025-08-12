package com.autoever.clazzi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.autoever.clazzi.model.Vote
import com.autoever.clazzi.repository.VoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VoteViewModel(
    private val voteRepository: VoteRepository
) : ViewModel() {
    private val _vote = MutableStateFlow<Vote?>(null)
    val vote: StateFlow<Vote?> = _vote

    fun loadVote(voteId: String) {
        viewModelScope.launch {
            voteRepository.observeVoteById(voteId).collect { vote ->
                _vote.value = vote
            }
        }
    }
}