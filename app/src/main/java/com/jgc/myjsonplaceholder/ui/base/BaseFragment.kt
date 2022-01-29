package com.jgc.myjsonplaceholder.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import com.jgc.myjsonplaceholder.R

abstract class BaseFragment<VIEWMODEL : BaseViewModel> : Fragment() {

    override fun onResume() {
        super.onResume()
        getViewModel().onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    abstract fun getViewModel(): VIEWMODEL

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