package com.jgc.myjsonplaceholder.ui.list

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
class ListFragmentViewModel @Inject constructor(
    private val getPostsUseCase: NetworkingUseCase.GetPostsUseCase,
) : BaseViewModel() {

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>> = _postList

    override fun onResume() {
        super.onResume()
        setViewState(ViewState.Loading)
        viewModelScope.launch {
            getPostsUseCase.execute(
                onDataReceived = {
                    if (it.isEmpty()) {
                        setViewState(ViewState.NoData)
                    } else {
                        _postList.value = it.toDomainLayer()
                        setViewState(ViewState.Data)
                    }
                },
                onError = { viewErrorCause: NetworkErrorCause, message: String ->
                    setViewState(ViewState.Error(viewErrorCause.map(), message))
                },
            )
        }
    }
}