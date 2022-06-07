package com.jgc.myjsonplaceholder.domain.repository.list

import com.jgc.myjsonplaceholder.domain.models.Post

interface ListRepository {
    fun getPostList(): List<Post>
}