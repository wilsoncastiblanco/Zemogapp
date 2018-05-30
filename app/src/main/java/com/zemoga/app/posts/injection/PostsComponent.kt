package com.zemoga.app.posts.injection

import com.zemoga.app.commons.injection.annotation.ActivityScope
import com.zemoga.app.commons.injection.components.CoreComponent
import com.zemoga.app.posts.view.PostsFragment
import dagger.Component

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
@ActivityScope
@Component(dependencies = [(CoreComponent::class)],
        modules = [(PostsModule::class), (PostsServiceModule::class)])
interface PostsComponent {
    fun inject(postsFragment: PostsFragment)
}