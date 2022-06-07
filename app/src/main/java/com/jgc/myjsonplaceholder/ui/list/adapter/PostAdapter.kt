package com.jgc.myjsonplaceholder.ui.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jgc.myjsonplaceholder.R
import com.jgc.myjsonplaceholder.domain.models.Post

class PostsDataAdapter(
    private var dataSet: List<Post> = emptyList(),
    itemClickListener: OnItemClickListener,
) : RecyclerView.Adapter<PostsDataAdapter.ViewHolder>() {

    private val listener: OnItemClickListener = itemClickListener

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<Post>) {
        this.dataSet = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvBody: TextView = view.findViewById(R.id.tvBody)
    }

    interface OnItemClickListener {
        fun onItemDetailsClick(
            post: Post,
        )
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(
        holder: PostsDataAdapter.ViewHolder,
        position: Int,
    ) {
        with(holder) {
            tvTitle.text = dataSet[position].title
            tvBody.text = dataSet[position].body
            itemView.setOnClickListener { listener.onItemDetailsClick(dataSet[position]) }
        }

    }
}
