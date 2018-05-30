package com.zemoga.app.commons.view

import android.arch.lifecycle.LifecycleRegistry
import android.support.v4.app.Fragment
import com.zemoga.app.commons.ZemogApplication
import com.zemoga.app.commons.injection.components.CoreComponent

/**
 * Created by wilsoncastiblanco on 5/30/18.
 */
open class BaseFragment : Fragment() {
    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    protected fun getCoreComponent(): CoreComponent? {
        return (context?.applicationContext as ZemogApplication).coreComponent
    }
}