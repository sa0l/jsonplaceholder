package com.jgc.myjsonplaceholder.domain.models

data class PostItemDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

fun List<PostItemDto>.toDomainLayer(): List<Post> = map {
    Post(
        id = it.id.toLong(),
        body = it.body,
        title = it.title
    )
}

fun PostItemDto.toDomainLayer(): Post = Post(
    id = this.id.toLong(),
    body = this.body,
    title = this.title
)

