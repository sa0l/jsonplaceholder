package com.jgc.myjsonplaceholder.domain.repository

import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.repository.list.ListRepository

class FakeListRepositoryImpl : ListRepository {
    override fun getPostList(): List<Post> {
        return emptyList()
    }
}