package com.autoever.clazzi.repository

import android.content.Context
import android.net.Uri
import com.autoever.clazzi.model.Vote
import com.autoever.clazzi.repository.network.VoteApiService
import kotlinx.coroutines.flow.Flow

class RestApiVoteRepository(
    private val api: VoteApiService,
) :VoteRepository {
    override fun observeVotes(): Flow<List<Vote>> {
        TODO("Not yet implemented")
    }

    override suspend fun addVote(vote: Vote, context: Context, imageUri: Uri) {
        TODO("Not yet implemented")
    }

    override suspend fun setVote(vote: Vote) {
        TODO("Not yet implemented")
    }

    override fun observeVoteById(voteId: String): Flow<Vote?> {
        TODO("Not yet implemented")
    }
}