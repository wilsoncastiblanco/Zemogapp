package com.zemoga.app.posts

import com.zemoga.app.commons.model.BasePresenter
import com.zemoga.app.commons.model.BaseView
import com.zemoga.app.posts.model.Post

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
interface PostsContract {

    interface View : BaseView {
        fun showPosts(posts: List<Post>)
    }

    interface Presenter : BasePresenter {
        fun loadPosts()
    }
}

