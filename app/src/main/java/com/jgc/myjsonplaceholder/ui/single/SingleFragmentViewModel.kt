package com.jgc.myjsonplaceholder.ui.single

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.models.toDomainLayer
import com.jgc.myjsonplaceholder.network.NetworkErrorCause
import com.jgc.myjsonplaceholder.network.NetworkingUseCase
import com.jgc.myjsonplaceholder.network.map
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleFragmentViewModel @Inject constructor(
    private val getSinglePost: NetworkingUseCase.GetSinglePostUseCase,
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
            setViewState(ViewState.Error(ViewErrorCause.MISSING_POST_ID, ""))
            return
        }
        viewModelScope.launch {
            getSinglePost.execute(
                postId = postId,
                onDataReceived = {
                    _postData.value = it.toDomainLayer()
                    setViewState(ViewState.Data)
                },
                onError = { viewErrorCause: NetworkErrorCause, message: String ->
                    setViewState(ViewState.Error(viewErrorCause.map(), message))
                }
            )
        }
    }
}
