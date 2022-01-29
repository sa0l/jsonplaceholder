package com.jgc.myjsonplaceholder.ui.list

import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListFragmentViewModel @Inject constructor() : BaseViewModel() {

    override fun onResume() {
        super.onResume()
    }

    enum class ListViewState {
        LOADING, DATA, ERROR
    }
}