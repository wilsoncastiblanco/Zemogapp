package com.zemoga.app.posts.model

import com.zemoga.app.commons.net.NetworkError
import com.zemoga.app.commons.net.ResponseEvent
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class PostsInteractor @Inject constructor(val postsInterface: PostsInterface) {

    fun loadPosts(listener: ResponseEvent<List<Posts>>): Subscription {
        return postsInterface.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            listener.onSuccess(response)
                        },
                        { err ->
                            listener.onServiceError(NetworkError(err))
                        },
                        { }
                )
    }
}