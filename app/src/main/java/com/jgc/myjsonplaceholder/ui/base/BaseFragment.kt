package com.jgc.myjsonplaceholder.ui.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<VIEWMODEL : BaseViewModel> : Fragment() {

    override fun onResume() {
        super.onResume()
        getViewModel().onResume()
    }

    abstract fun getViewModel(): VIEWMODEL

}