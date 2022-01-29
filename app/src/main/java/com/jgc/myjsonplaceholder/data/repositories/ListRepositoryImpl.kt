package com.jgc.myjsonplaceholder.data.repositories

import com.jgc.myjsonplaceholder.data.dto.PostItemDto
import com.jgc.myjsonplaceholder.domain.ListRepository
import com.jgc.myjsonplaceholder.domain.models.Post

class ListRepositoryImpl : ListRepository {
    override fun getPostList(): List<Post> = listOf(
        PostItemDto(
            id = 1,
            body = "body1",
            title = "title1",
            userId = 1
        ), PostItemDto(
            id = 2,
            body = "body2",
            title = "title2",
            userId = 2
        )
    ).toDomainLayer()
}

fun List<PostItemDto>.toDomainLayer(): List<Post> = map {
    Post(
        id = it.id,
        body = it.body,
        title = it.title,
        userId = it.userId
    )
}