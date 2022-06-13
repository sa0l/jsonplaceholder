package com.jgc.myjsonplaceholder.network

import com.jgc.myjsonplaceholder.domain.models.PostItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderApi {
    @GET("/posts")
    suspend fun getTodosList(): Response<List<PostItemDto>>

    @GET("/posts/{postId}")
    suspend fun getSingleTodo(@Path("postId") postId: String): Response<PostItemDto>

}