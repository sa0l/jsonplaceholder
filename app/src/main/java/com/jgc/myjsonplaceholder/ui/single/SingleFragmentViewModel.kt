package com.jgc.myjsonplaceholder.ui.single

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.usecase.PostUseCase
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingleFragmentViewModel @Inject constructor(
    private val getSinglePost: PostUseCase.GetSinglePost,
) : BaseViewModel() {

    private val _postData: MutableLiveData<Post> = MutableLiveData()
    val postData: LiveData<Post> = _postData

    private val _requestedNavigation = MutableLiveData<Boolean>()
    val requestedNavigation: LiveData<Boolean> = _requestedNavigation

    fun onToolbarBack() {
        _requestedNavigation.postValue(true)
    }

    fun onPostIdReceived(postId: String?) {
        if (postId.isNullOrBlank()) {
            setViewState(ViewState.Error(ViewErrorCause.MISSING_POST_ID))
            return
        }
        getSinglePost.execute(
            postId = postId,
            scope = viewModelScope,
            onDataReceived = {
                _postData.value = it
                setViewState(ViewState.Data)
            },
            onError = {
                setViewState(ViewState.Error(it))
            }
        )
    }
}
