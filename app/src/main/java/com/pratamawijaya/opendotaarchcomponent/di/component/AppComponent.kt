package com.pratamawijaya.opendotaarchcomponent.di.component

import com.pratamawijaya.opendotaarchcomponent.di.module.AppModule
import com.pratamawijaya.opendotaarchcomponent.di.module.LocalModule
import com.pratamawijaya.opendotaarchcomponent.di.module.RemoteModule
import com.pratamawijaya.opendotaarchcomponent.presentation.ProMatchesViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by pratama on 8/10/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        LocalModule::class,
        RemoteModule::class))
interface AppComponent {

    fun inject(vm: ProMatchesViewModel)
}