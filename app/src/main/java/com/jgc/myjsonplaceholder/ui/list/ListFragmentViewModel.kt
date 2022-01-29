package com.jgc.myjsonplaceholder.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.usecase.PostUseCase
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    private val getPostsUseCase: PostUseCase.GetPostsUseCase
) : BaseViewModel() {

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>> = _postList

    override fun onResume() {
        super.onResume()
        setViewState(ViewState.Loading)
        getPostsUseCase.execute(onDataReceived = {
            _postList.value = it
            setViewState(ViewState.Data)
        }, onError = {
            setViewState(ViewState.Error(it))
        })
    }
}