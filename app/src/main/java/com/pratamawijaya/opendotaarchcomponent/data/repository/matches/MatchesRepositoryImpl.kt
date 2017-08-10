package com.pratamawijaya.opendotaarchcomponent.data.repository.matches

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.pratamawijaya.opendotaarchcomponent.data.OpenDotaApi
import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by pratama on 8/10/17.
 */
class MatchesRepositoryImpl @Inject constructor(private val services: OpenDotaApi) : MatchesRepository {

    override fun getProMatches(): LiveData<List<Matches>> {
        val mutableLiveData = MutableLiveData<List<Matches>>()

        services.getProMatches()
                .flatMap { Observable.fromIterable(it) }
                .map {
                    Matches(id = it.matchId,
                            direName = it.direName,
                            duration = it.duration,
                            leagueName = it.leagueName,
                            radiantName = it.radiantName)
                }
                .toList()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    mutableLiveData.value = result
                }, { error ->
                    throw Throwable(error.localizedMessage)
                })
        return mutableLiveData
    }
}