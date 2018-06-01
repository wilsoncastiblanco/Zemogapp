package com.zemoga.app.posts.presenter

import com.zemoga.app.R
import com.zemoga.app.commons.net.NetworkError
import com.zemoga.app.commons.net.ResponseEvent
import com.zemoga.app.posts.PostsContract
import com.zemoga.app.posts.model.Post
import com.zemoga.app.posts.model.PostsInteractor
import rx.subscriptions.CompositeSubscription

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class PostsPresenter(val interactor: PostsInteractor,
                     val view: PostsContract.View) : PostsContract.Presenter {
    private val subscriptions: CompositeSubscription = CompositeSubscription()


    override fun loadPosts() {
        val subscription = interactor.loadPosts(object : ResponseEvent<List<Post>> {
            override fun onSuccess(response: List<Post>) {
                view.showPosts(response)
            }

            override fun onServiceError(error: NetworkError) {

            }

            override fun onError(response: List<Post>) {
                view.showError(R.string.something_went_wrong)
            }
        })
        subscriptions.add(subscription)
    }

    override fun onDestroy() {
        subscriptions.clear()
    }
}