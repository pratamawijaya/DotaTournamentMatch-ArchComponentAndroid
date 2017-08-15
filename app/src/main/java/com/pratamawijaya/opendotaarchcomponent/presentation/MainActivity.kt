package com.pratamawijaya.opendotaarchcomponent.presentation

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.github.nitrico.lastadapter.LastAdapter
import com.pratamawijaya.opendotaarchcomponent.BR
import com.pratamawijaya.opendotaarchcomponent.R
import com.pratamawijaya.opendotaarchcomponent.domain.Matches

class MainActivity : LifecycleActivity() {

    private lateinit var proMatchesVM: ProMatchesViewModel
    private lateinit var rvMatches: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        proMatchesVM = ViewModelProviders.of(this).get(ProMatchesViewModel::class.java)

        rvMatches = findViewById(R.id.rvMatches)
        rvMatches.layoutManager = LinearLayoutManager(this)

        proMatchesVM.getProMatchesData().observe(this, Observer {
            result ->
            LastAdapter(result!!, BR.matches)
                    .map<Matches>(R.layout.layout_item_matches)
                    .into(rvMatches)
        })
    }
}
