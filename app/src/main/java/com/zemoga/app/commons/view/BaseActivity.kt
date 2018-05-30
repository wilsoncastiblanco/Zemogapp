package com.zemoga.app.commons.view

import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity
import com.zemoga.app.commons.ZemogApplication
import com.zemoga.app.commons.injection.components.CoreComponent

open class BaseActivity : AppCompatActivity() {

    private val lifecycleRegistry = LifecycleRegistry(this)

    protected fun getCoreComponent(): CoreComponent? {
        return (application as ZemogApplication).coreComponent
    }

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }
}
