package com.jgc.myjsonplaceholder.data.repositories

import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.repository.single.SinglePostRepository

class SinglePostRepositoryImpl : SinglePostRepository {
    override fun getPost(id: String): Post {
        return Post(id = 1, body = "bodty", title = "tytl")
    }
}