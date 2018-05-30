package com.zemoga.app.posts.injection

import com.zemoga.app.commons.injection.annotation.ActivityScope
import com.zemoga.app.posts.PostsContract
import com.zemoga.app.posts.model.PostsInteractor
import com.zemoga.app.posts.presenter.PostsPresenter
import com.zemoga.app.posts.view.PostsFragment
import dagger.Module
import dagger.Provides

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
@ActivityScope
@Module
class PostsModule(postFragment: PostsFragment) {
    private val view: PostsContract.View = postFragment

    @Provides
    fun provideView(): PostsContract.View {
        return view
    }

    @Provides
    fun providePresenter(interactor: PostsInteractor, view: PostsContract.View): PostsContract.Presenter {
        return PostsPresenter(interactor, view)
    }
}