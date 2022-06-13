package com.jgc.myjsonplaceholder.network

import android.util.Log
import com.jgc.myjsonplaceholder.domain.models.PostItemDto
import javax.inject.Inject

class NetworkManagerImpl @Inject constructor(
    private val api: JsonPlaceholderApi,
) : NetworkManager {
    override suspend fun getPostsList(
        dataDelegate: (List<PostItemDto>) -> Unit,
        responseDelegate: (response: NetworkResponse) -> Unit,
    ) {
        val response = api.getTodosList()
        if (response.isSuccessful && response.body() != null) {
            dataDelegate(response.body()!!)
            responseDelegate(NetworkResponse.OK)
        } else {
            responseDelegate(NetworkResponse.ERROR(cause = NetworkErrorCause.GENERIC))
        }
    }

    override suspend fun getSinglePost(
        postId: String,
        dataDelegate: (PostItemDto) -> Unit,
        responseDelegate: (response: NetworkResponse) -> Unit,
    ) {
        val response = api.getSingleTodo(postId)
        if (response.isSuccessful && response.body() != null) {
            dataDelegate(response.body()!!)
            responseDelegate(NetworkResponse.OK)
        } else {
            Log.e("michu", "error response : ${response.errorBody()}")
            responseDelegate(NetworkResponse.ERROR(cause = NetworkErrorCause.GENERIC))
        }
    }
}