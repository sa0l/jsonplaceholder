package com.jgc.myjsonplaceholder.domain.models

data class Post(
    val id: Int,
    val body: String,
    val title: String,
    val userId: Int
)