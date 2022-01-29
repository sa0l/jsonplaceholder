package com.jgc.myjsonplaceholder.ui.list

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.domain.usecase.PostUseCase
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import com.jgc.myjsonplaceholder.ui.list.adapter.PostListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    private val getPostsUseCase: PostUseCase.GetPostsUseCase
) : BaseViewModel(), PostListener {

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    val postList: LiveData<List<Post>> = _postList

    override fun onResume() {
        super.onResume()
        setViewState(ViewState.Loading)
        getPostsUseCase.execute(
            onDataReceived = {
                _postList.value = it
                setViewState(ViewState.Data)
            },
            onError = {
                setViewState(ViewState.Error(it))
            },
            scope = viewModelScope
        )
    }

    override fun onPostClicked(post: Post) {
        Log.w("michu", "onPostClicked: $post")
    }
}