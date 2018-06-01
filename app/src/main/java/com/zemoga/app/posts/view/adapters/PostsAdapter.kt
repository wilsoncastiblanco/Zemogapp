package com.zemoga.app.posts.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zemoga.app.R
import com.zemoga.app.posts.model.Post
import kotlinx.android.synthetic.main.item_posts.view.*

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class PostsAdapter(val context: Context) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    private var mPostsList: List<Post> = listOf()
    private var listener: Listener

    init {
        if (context is Listener) {
            listener = context
        } else {
            throw IllegalArgumentException("The activity or the fragment using this adapter needs to implement the " + Listener::class.java.simpleName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_posts, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = mPostsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindPost(mPostsList[position])

    fun setData(postsList: List<Post>) {
        this.mPostsList = postsList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPost(post: Post) {
            itemView.postDescription.text = post.body
            itemView.setOnClickListener({
                listener.onPostClicked(post)
            })
        }
    }

    interface Listener {
        fun onPostClicked(post: Post)
    }
}