package com.zemoga.app.commons.model

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
interface BaseView {
    fun showError(error: Int)
    fun showError(message: String)
}