package com.autoever.clazzi.model

data class Message (
    val senderId: String,
    val content: String,
    val timestamp: Long
)