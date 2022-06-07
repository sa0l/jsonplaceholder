package com.jgc.myjsonplaceholder.domain.repository.single

import com.jgc.myjsonplaceholder.domain.models.Post

interface SinglePostRepository {
    fun getPost(id: String): Post
}