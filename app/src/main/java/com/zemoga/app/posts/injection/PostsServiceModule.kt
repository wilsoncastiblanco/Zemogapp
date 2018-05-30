package com.zemoga.app.posts.injection

import com.zemoga.app.commons.injection.annotation.ActivityScope
import com.zemoga.app.posts.model.PostsInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
@ActivityScope
@Module
class PostsServiceModule {

    @Provides
    fun providePostsInterface(retrofit: Retrofit): PostsInterface {
        return retrofit.create(PostsInterface::class.java)
    }
}