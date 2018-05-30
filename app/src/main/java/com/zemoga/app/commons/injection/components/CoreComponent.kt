package com.zemoga.app.commons.injection.components

import android.content.Context
import com.zemoga.app.commons.injection.modules.ApplicationModule
import com.zemoga.app.commons.injection.modules.NetModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
@Singleton
@Component(modules = [(ApplicationModule::class), (NetModule::class)])
interface CoreComponent {
    val retrofit: Retrofit
    val context: Context
}
