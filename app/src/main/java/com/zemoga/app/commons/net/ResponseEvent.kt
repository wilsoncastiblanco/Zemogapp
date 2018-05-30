package com.zemoga.app.commons.net

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
interface ResponseEvent<in T> {
    fun onSuccess(response: T)
    fun onServiceError(error: NetworkError)
    fun onError(response: T)
}