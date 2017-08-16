package com.pratamawijaya.opendotaarchcomponent.presentation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.pratamawijaya.opendotaarchcomponent.BaseApp
import com.pratamawijaya.opendotaarchcomponent.data.repository.matches.MatchesRepoLiveData
import com.pratamawijaya.opendotaarchcomponent.data.repository.matches.MatchesRepository
import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import javax.inject.Inject

/**
 * Created by pratama on 8/10/17.
 */
class ProMatchesViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var matchesRepo: MatchesRepository

    init {
        BaseApp.appComponent.inject(this)
    }

    private val matchesLiveData = MutableLiveData<List<Matches>>()


    val resultLiveData = MatchesRepoLiveData(matchesRepo).apply {
        this.addSource(matchesLiveData, null)
    }

    val isLoadingLiveData = MediatorLiveData<Boolean>().apply {
        this.addSource(resultLiveData) { this.value = false }
    }

    val throwableLiveData = MediatorLiveData<Throwable>().apply {
        this.addSource(resultLiveData) { it?.second?.let { this.value = it } }
    }

    val reposLiveData = MediatorLiveData<List<Matches>>().apply {
        this.addSource(resultLiveData) { it?.first?.let { this.value = it } }
    }

}