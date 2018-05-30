package com.zemoga.app.commons.injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
@Module
class ApplicationModule(private val context: Context) {

    @Provides
    internal fun provideContext(): Context {
        return context
    }
}