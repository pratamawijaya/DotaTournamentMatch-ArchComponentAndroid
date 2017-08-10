package com.pratamawijaya.opendotaarchcomponent

import android.app.Application
import com.pratamawijaya.opendotaarchcomponent.di.component.AppComponent
import com.pratamawijaya.opendotaarchcomponent.di.component.DaggerAppComponent
import com.pratamawijaya.opendotaarchcomponent.di.module.AppModule
import com.pratamawijaya.opendotaarchcomponent.di.module.LocalModule
import com.pratamawijaya.opendotaarchcomponent.di.module.RemoteModule
import timber.log.Timber

/**
 * Created by pratama on 8/10/17.
 */
class BaseApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .localModule(LocalModule())
                .remoteModule(RemoteModule())
                .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}