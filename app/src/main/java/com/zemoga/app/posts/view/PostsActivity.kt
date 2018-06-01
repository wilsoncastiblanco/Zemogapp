package com.zemoga.app.posts.view

import android.os.Bundle
import com.zemoga.app.R
import com.zemoga.app.commons.view.BaseActivity
import com.zemoga.app.posts.view.adapters.PostsPagerAdapter
import kotlinx.android.synthetic.main.content_posts.*
import kotlinx.android.synthetic.main.view_app_bar.*


class PostsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        setSupportActionBar(toolbar)
        postsViewPager.adapter = PostsPagerAdapter(supportFragmentManager)
        slidingTabs.setupWithViewPager(postsViewPager)
    }
}
