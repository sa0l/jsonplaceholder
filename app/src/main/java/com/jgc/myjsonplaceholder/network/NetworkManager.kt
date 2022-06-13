package com.jgc.myjsonplaceholder.network

import com.jgc.myjsonplaceholder.domain.models.PostItemDto

interface NetworkManager {
    suspend fun getPostsList(
        dataDelegate: (List<PostItemDto>) -> Unit,
        responseDelegate: (response: NetworkResponse) -> Unit,
    )

    suspend fun getSinglePost(
        postId: String,
        dataDelegate: (PostItemDto) -> Unit,
        responseDelegate: (response: NetworkResponse) -> Unit,
    )
}