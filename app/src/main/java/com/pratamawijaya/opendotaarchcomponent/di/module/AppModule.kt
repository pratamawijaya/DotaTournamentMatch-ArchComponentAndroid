package com.pratamawijaya.opendotaarchcomponent.di.module

import android.content.Context
import com.pratamawijaya.opendotaarchcomponent.BaseApp
import com.pratamawijaya.opendotaarchcomponent.di.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Created by pratama on 8/10/17.
 */
@Module
class AppModule(val app: BaseApp) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = app

}