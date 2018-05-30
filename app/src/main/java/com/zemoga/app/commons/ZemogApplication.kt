package com.zemoga.app.commons

import android.app.Application
import com.zemoga.app.commons.injection.components.CoreComponent
import com.zemoga.app.commons.injection.components.DaggerCoreComponent
import com.zemoga.app.commons.injection.modules.ApplicationModule
import com.zemoga.app.commons.injection.modules.NetModule

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class ZemogApplication : Application() {

    var coreComponent: CoreComponent? = null

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
                .applicationModule(ApplicationModule(this))
                .netModule(NetModule())
                .build()
    }
}