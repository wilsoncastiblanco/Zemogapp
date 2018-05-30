package com.zemoga.app.posts.view

import android.os.Bundle
import com.zemoga.app.R
import com.zemoga.app.commons.view.BaseActivity
import com.zemoga.app.posts.view.adapters.PostsPagerAdapter
import kotlinx.android.synthetic.main.content_posts.*


class PostsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.posts_activity)

        postsViewPager.adapter = PostsPagerAdapter(supportFragmentManager)
        slidingTabs.setupWithViewPager(postsViewPager)
    }
}
