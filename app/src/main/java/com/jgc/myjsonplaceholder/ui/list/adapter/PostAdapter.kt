package com.jgc.myjsonplaceholder.ui.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.jgc.myjsonplaceholder.databinding.PostItemBinding
import com.jgc.myjsonplaceholder.domain.models.Post

class PostAdapter(
    itemClickListener: OnItemClickListener,
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var dataSet: List<Post> = emptyList()
    private val listener: OnItemClickListener = itemClickListener

    class ViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.setVariable(BR.post, dataSet[position])
        holder.binding.setVariable(BR.listener, listener)
    }

    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<Post>) {
        this.dataSet = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemDetailsClick(
            post: Post,
        )
    }
}