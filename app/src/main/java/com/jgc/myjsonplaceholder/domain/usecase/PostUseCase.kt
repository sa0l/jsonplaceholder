package com.jgc.myjsonplaceholder.domain.usecase

import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.repository.list.ListRepository
import com.jgc.myjsonplaceholder.domain.repository.single.SinglePostRepository
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PostUseCase {
    class GetPostsUseCase @Inject constructor(private val repository: ListRepository) :
        PostUseCase() {
        fun execute(
            scope: CoroutineScope,
            onDataReceived: (List<Post>) -> Unit,
            onError: (BaseViewModel.ViewErrorCause) -> Unit,
        ) {
            onDataReceived(repository.getPostList())
        }
    }

    class GetSinglePost @Inject constructor(private val repository: SinglePostRepository) :
        PostUseCase() {
        fun execute(
            postId: String,
            scope: CoroutineScope,
            onDataReceived: (Post) -> Unit,
            onError: (BaseViewModel.ViewErrorCause) -> Unit,
        ) {
            scope.launch {
                delay(1000L)
                onDataReceived(repository.getPost(postId))
            }
        }
    }
}