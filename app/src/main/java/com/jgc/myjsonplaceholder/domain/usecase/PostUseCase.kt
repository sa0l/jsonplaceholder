package com.jgc.myjsonplaceholder.domain.usecase

import com.jgc.myjsonplaceholder.domain.ListRepository
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import javax.inject.Inject

sealed class PostUseCase {
    class GetPostsUseCase @Inject constructor(private val repository: ListRepository) :
        PostUseCase() {
        fun execute(
            onDataReceived: (List<Post>) -> Unit,
            onError: (BaseViewModel.ViewErrorCause) -> Unit
        ) {
            onDataReceived(repository.getPostList())
        }
    }
}