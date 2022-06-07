package com.jgc.myjsonplaceholder.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.repository.FakeGetListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetPostsUseCaseTest {

    private lateinit var getPosts: PostUseCase.GetPostsUseCase

    private lateinit var fakeGetListRepository: FakeGetListRepository

    @get:Rule
    var instantTaskExecutionRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        fakeGetListRepository = FakeGetListRepository()
        getPosts = PostUseCase.GetPostsUseCase(repository = fakeGetListRepository)
    }

    @Test
    fun testShouldSuccessReturnEmptyList() = runTest {
        var receivedList = listOf<Post>()
        getPosts.execute(
            scope = this,
            onDataReceived = {
                receivedList = it//listOf(Post(id = 0, body = "", title = ""))
            },
            onError = {}
        )
        assert(receivedList.isEmpty())
    }
}