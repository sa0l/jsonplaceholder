package com.jgc.myjsonplaceholder.ui.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<VIEWMODEL : BaseViewModel> : Fragment() {

    override fun onResume() {
        super.onResume()
        getViewModel().onResume()
        getViewModel().viewState.observe(this) {
            when (it) {
                BaseViewModel.ViewState.Data -> {
                    getViewModel().hideLoader()
                }
                is BaseViewModel.ViewState.Error -> {
                    getViewModel().hideLoader()
                }
                BaseViewModel.ViewState.Loading -> {
                    getViewModel().showLoader()
                }
                BaseViewModel.ViewState.NoData -> {
                    getViewModel().hideLoader()
                }
            }
        }
    }

    abstract fun getViewModel(): VIEWMODEL

}