package com.jgc.myjsonplaceholder.network

import com.jgc.myjsonplaceholder.ui.base.BaseViewModel

sealed class NetworkResponse {
    object OK : NetworkResponse()
    class ERROR(val cause: NetworkErrorCause, val message: String? = null) : NetworkResponse()
}

enum class NetworkErrorCause {
    GENERIC,
}

fun NetworkErrorCause.map(): BaseViewModel.ViewErrorCause =
    BaseViewModel.ViewErrorCause.NETWORK_ERROR
