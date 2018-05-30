package com.zemoga.app.posts.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.zemoga.app.R
import com.zemoga.app.commons.net.NetworkError
import com.zemoga.app.commons.net.ResponseEvent
import com.zemoga.app.posts.PostsContract
import com.zemoga.app.posts.model.Posts
import com.zemoga.app.posts.model.PostsInteractor
import rx.subscriptions.CompositeSubscription

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class PostsPresenter(val interactor: PostsInteractor,
                     val view: PostsContract.View) : PostsContract.Presenter, LifecycleObserver {
    private val subscriptions: CompositeSubscription = CompositeSubscription()

    init {
        if (view is LifecycleOwner) {
            (view as LifecycleOwner).lifecycle.addObserver(this)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun loadPosts() {
        val subscription = interactor.loadPosts(object : ResponseEvent<List<Posts>> {
            override fun onSuccess(response: List<Posts>) {
                view.showPosts(response)
            }

            override fun onServiceError(error: NetworkError) {

            }

            override fun onError(response: List<Posts>) {
                view.showError(R.string.something_went_wrong)
            }
        })
        subscriptions.add(subscription)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        subscriptions.clear()
    }
}