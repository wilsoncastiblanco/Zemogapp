package com.zemoga.app.posts.model

import retrofit2.http.GET
import rx.Observable

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
interface PostsInterface {
    @GET("/posts")
    fun getPosts(): Observable<List<Posts>>
}