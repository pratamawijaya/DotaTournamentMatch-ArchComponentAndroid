package com.pratamawijaya.opendotaarchcomponent.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.pratamawijaya.opendotaarchcomponent.BaseApp
import com.pratamawijaya.opendotaarchcomponent.data.repository.matches.MatchesRepository
import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import javax.inject.Inject

/**
 * Created by pratama on 8/10/17.
 */
class ProMatchesViewModel : ViewModel() {

    @Inject
    lateinit var matchesRepo: MatchesRepository

    private var liveMatchesData: LiveData<List<Matches>>? = null

    init {
        initDagger()
    }

    fun getProMatchesData(): LiveData<List<Matches>>? {
        liveMatchesData = matchesRepo.getProMatches()
        return liveMatchesData
    }

    private fun initDagger() {
        BaseApp.appComponent.inject(this)
    }
}