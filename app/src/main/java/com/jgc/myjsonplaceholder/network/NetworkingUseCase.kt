package com.jgc.myjsonplaceholder.network

import com.jgc.myjsonplaceholder.domain.models.PostItemDto
import javax.inject.Inject

sealed class NetworkingUseCase {

    class GetPostsUseCase @Inject constructor(
        private val networkManager: NetworkManager,
    ) : NetworkingUseCase() {
        suspend fun execute(
            onDataReceived: (List<PostItemDto>) -> Unit,
            onError: (NetworkErrorCause, String) -> Unit,
        ) {
            networkManager.getPostsList(dataDelegate = {
                onDataReceived(it)
            }, responseDelegate = {
                when (it) {
                    is NetworkResponse.ERROR -> onError(it.cause, it.message ?: "")
                    NetworkResponse.OK -> {}
                }
            })
        }
    }

    class GetSinglePostUseCase @Inject constructor(
        private val networkManager: NetworkManager,
    ) : NetworkingUseCase() {

        suspend fun execute(
            postId: String,
            onDataReceived: (PostItemDto) -> Unit,
            onError: (NetworkErrorCause, String) -> Unit,
        ) {
            networkManager.getSinglePost(postId = postId,
                dataDelegate = onDataReceived,
                responseDelegate = {
                    when (it) {
                        is NetworkResponse.ERROR -> onError(it.cause, it.message ?: "")
                        NetworkResponse.OK -> {}
                    }
                })
        }
    }
}