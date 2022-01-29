package com.jgc.myjsonplaceholder.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    open fun onResume() {}

    fun showLoading() {}

    fun hideLoading() {}
}
