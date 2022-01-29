package com.jgc.myjsonplaceholder.ui.list.adapter

import com.jgc.myjsonplaceholder.R
import com.jgc.myjsonplaceholder.databinding.PostItemBinding
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.ui.base.adapter.BaseAdapter

class PostAdapter(
    private val list: List<Post>,
    private val postListener: PostListener
) : BaseAdapter<PostItemBinding, Post>(list) {
    override val layoutId: Int
        get() = R.layout.post_item

    override fun bind(binding: PostItemBinding, item: Post) {
        binding.apply {
            post = item
            listener = postListener
            executePendingBindings()
        }
    }

}

interface PostListener {
    fun onPostClicked(post: Post)

}