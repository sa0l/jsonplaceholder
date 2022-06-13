package com.jgc.myjsonplaceholder.domain.models

import com.jgc.myjsonplaceholder.ui.base.adapter.ListAdapterItem

data class Post(
    override val id: Long,
    val body: String,
    val title: String,
) : ListAdapterItem