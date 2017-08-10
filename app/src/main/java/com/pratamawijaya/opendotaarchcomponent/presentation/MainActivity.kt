package com.pratamawijaya.opendotaarchcomponent.presentation

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.github.ajalt.timberkt.d
import com.pratamawijaya.opendotaarchcomponent.R

class MainActivity : LifecycleActivity() {

    private var proMatchesVM: ProMatchesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    private fun initViewModel() {
        proMatchesVM = ViewModelProviders.of(this).get(ProMatchesViewModel::class.java)
        proMatchesVM?.getProMatchesData()?.observe(this, Observer {
            result ->
            result?.map {
                d { "result nya ${it.id} ${it.leagueName} ${it.radiantName} vs ${it.direName}" }
            }
        })
    }
}
