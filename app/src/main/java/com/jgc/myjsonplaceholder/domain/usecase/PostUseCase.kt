package com.jgc.myjsonplaceholder.domain.usecase

import com.jgc.myjsonplaceholder.domain.ListRepository
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PostUseCase {
    class GetPostsUseCase @Inject constructor(private val repository: ListRepository) :
        PostUseCase() {
        fun execute(
            scope: CoroutineScope,
            onDataReceived: (List<Post>) -> Unit,
            onError: (BaseViewModel.ViewErrorCause) -> Unit
        ) {
            scope.launch {
                onDataReceived(repository.getPostList())
            }
        }
    }
}