package com.zemoga.app.posts.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.zemoga.app.R
import com.zemoga.app.commons.view.BaseActivity
import com.zemoga.app.posts.model.Post

/**
 * Created by wilsoncastiblanco on 5/30/18.
 */

const val POST_EXTRA = "post_extra"

class PostsDetailActivity : BaseActivity() {

    private lateinit var post: Post

    companion object {
        fun createIntent(context: Context, post: Post): Intent {
            val intent = Intent(context, PostsDetailActivity::class.java)
            intent.putExtra(POST_EXTRA, post)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
        post = intent.extras.getParcelable(POST_EXTRA)
    }


}