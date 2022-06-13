package com.jgc.myjsonplaceholder.ui.base.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.ui.base.BaseViewModel
import com.jgc.myjsonplaceholder.ui.list.adapter.PostAdapter
import com.jgc.myjsonplaceholder.utils.setVisibleOrGone

@BindingAdapter("submitList")
fun submitList(recyclerView: RecyclerView, list: List<Post>?) {
    val adapter = recyclerView.adapter as PostAdapter
    adapter.updateData(list ?: listOf())
}

@BindingAdapter("app:showOnViewError")
fun TextView.showOnViewError(viewState: BaseViewModel.ViewState) {
    visibility = if (viewState is BaseViewModel.ViewState.Error)
        View.VISIBLE
    else
        View.GONE
}

object ViewBindingAdapters {
    @JvmStatic
    @BindingAdapter("app:isVisible")
    fun isVisible(view: View, isVisible: Boolean) {
        view setVisibleOrGone isVisible
    }
}
