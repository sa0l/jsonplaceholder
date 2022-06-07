package com.jgc.myjsonplaceholder.ui.base.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.ui.list.adapter.PostAdapter
import com.jgc.myjsonplaceholder.utils.setVisibleOrGone

@BindingAdapter("submitList")
fun submitList(recyclerView: RecyclerView, list: List<Post>?) {
    val adapter = recyclerView.adapter as PostAdapter
    adapter.updateData(list ?: listOf())
}

object ViewBindingAdapters {
    @JvmStatic
    @BindingAdapter("app:isVisible")
    fun isVisible(view: View, isVisible: Boolean) {
        view setVisibleOrGone isVisible
    }
}
