package com.pratamawijaya.opendotaarchcomponent.presentation

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.github.ajalt.timberkt.d
import com.github.nitrico.lastadapter.LastAdapter
import com.pratamawijaya.opendotaarchcomponent.BR
import com.pratamawijaya.opendotaarchcomponent.R
import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import com.pratamawijaya.opendotaarchcomponent.presentation.base.BaseLifecycleActivity
import com.pratamawijaya.opendotaarchcomponent.unsafeLazy
import org.jetbrains.anko.toast

class MainActivity : BaseLifecycleActivity<ProMatchesViewModel>() {

    private val rv by unsafeLazy { findViewById<RecyclerView>(R.id.rvMatches) }
    private val refresh by unsafeLazy { findViewById<SwipeRefreshLayout>(R.id.refreshLayout) }

    override val viewModelClass = ProMatchesViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.layoutManager = LinearLayoutManager(this)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.isLoadingLiveData.observe(this, Observer {
            it?.let {
                d { "is refresh $it" }
                refresh.isRefreshing = it
            }
        })

        viewModel.reposLiveData.observe(this, Observer {
            LastAdapter(it!!, BR.matchesLiveData)
                    .map<Matches>(R.layout.layout_item_matches)
                    .into(rv)
        })

        viewModel.throwableLiveData.observe(this, Observer {
            toast("error ${it?.localizedMessage}")
        })

    }

}
