package com.jgc.myjsonplaceholder.domain

import com.jgc.myjsonplaceholder.domain.models.Post

interface ListRepository {
    fun getPostList(): List<Post>
}