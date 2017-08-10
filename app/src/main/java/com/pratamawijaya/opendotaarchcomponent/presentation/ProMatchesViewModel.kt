package com.pratamawijaya.opendotaarchcomponent.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.github.ajalt.timberkt.d
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
        BaseApp.appComponent.inject(this)
    }

    fun getProMatchesData(): LiveData<List<Matches>> {
        if (liveMatchesData == null) {
            liveMatchesData = MutableLiveData<List<Matches>>()
            liveMatchesData = matchesRepo.getProMatches()
        }
        return liveMatchesData as LiveData<List<Matches>>
    }

    override fun onCleared() {
        super.onCleared()
        d { "vm cleared" }
    }
}