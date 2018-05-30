package com.zemoga.app.posts.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zemoga.app.R
import com.zemoga.app.commons.view.BaseFragment
import com.zemoga.app.posts.PostsContract
import com.zemoga.app.posts.injection.DaggerPostsComponent
import com.zemoga.app.posts.injection.PostsModule
import com.zemoga.app.posts.model.Posts
import com.zemoga.app.posts.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.posts_fragment.*
import javax.inject.Inject

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */

class PostsFragment : BaseFragment(), PostsContract.View {

    @Inject
    lateinit var presenter: PostsContract.Presenter

    companion object {
        fun newInstance(position: Int): PostsFragment {
            return PostsFragment()
        }
    }

    private lateinit var postsAdapter: PostsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerPostsComponent.builder()
                .coreComponent(getCoreComponent())
                .postsModule(PostsModule(this))
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.posts_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postsRecyclerView()
    }

    private fun postsRecyclerView() {
        val mContext = context
        mContext?.let {
            postsAdapter = PostsAdapter(mContext)
            recyclerViewPosts.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
            recyclerViewPosts.adapter = postsAdapter
            recyclerViewPosts.addItemDecoration(DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL))
        }
    }

    override fun showPosts(posts: List<Posts>) {
        postsAdapter.setData(posts)
    }

    override fun showError(error: Int) {
        showError(getString(error))
    }

    override fun showError(message: String) {
        Snackbar.make(
                recyclerViewPosts,
                message,
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.button_retry)) {
                    //retry
                }.show()
    }
}