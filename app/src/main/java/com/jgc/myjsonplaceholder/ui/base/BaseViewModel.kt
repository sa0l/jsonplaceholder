package com.jgc.myjsonplaceholder.ui.base

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _viewState: MutableLiveData<ViewState> = MutableLiveData(ViewState.Loading)
    val viewState: LiveData<ViewState> = _viewState

    open fun onResume() {}

    fun showLoading() {}

    fun hideLoading() {}

    fun setViewState(newState: ViewState) {
        if (_viewState.value != newState)
            _viewState.value = newState
    }

    sealed class ViewState {
        object Loading : ViewState()
        object Data : ViewState()
        object NoData : ViewState()
        class Error(val cause: ViewErrorCause) : ViewState()
    }

    enum class ViewErrorCause {
        @Keep
        NETWORK_ERROR,

        @Keep
        APP_TOO_OLD,

        @Keep
        WRONG_SYSTEM_TIME,

        @Keep
        DATA_PARSING
    }
}
