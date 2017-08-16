package com.pratamawijaya.opendotaarchcomponent.presentation.base

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.pratamawijaya.opendotaarchcomponent.unsafeLazy

/**
 * Created by pratama on 8/16/17.
 */
abstract class BaseLifecycleActivity<T : AndroidViewModel> : AppCompatActivity(), LifecycleRegistryOwner {
    abstract val viewModelClass: Class<T>

    protected val viewModel: T by unsafeLazy { ViewModelProviders.of(this).get(viewModelClass) }

    private val registry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = registry
}