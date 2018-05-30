package com.zemoga.app.posts.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zemoga.app.R
import com.zemoga.app.posts.model.Posts
import kotlinx.android.synthetic.main.item_posts.view.*

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class PostsAdapter(val context: Context) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    private var mPostsList: List<Posts> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_posts, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = mPostsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindPost(mPostsList[position])

    fun setData(postsList: List<Posts>) {
        this.mPostsList = postsList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPost(post: Posts) {
            itemView.postDescription.text = post.body
        }
    }
}