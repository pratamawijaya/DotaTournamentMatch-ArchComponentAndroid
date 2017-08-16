package com.pratamawijaya.opendotaarchcomponent.data.repository.matches

import android.arch.lifecycle.MediatorLiveData
import com.github.ajalt.timberkt.d
import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by pratama on 8/16/17.
 */
class MatchesRepoLiveData @Inject constructor(repository: MatchesRepository) : MediatorLiveData<Pair<List<Matches>, Throwable>>() {

    private var disposable: Disposable? = null

    init {
        disposable = repository.getProMatches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result, error -> this@MatchesRepoLiveData.value = Pair(result, error) }
    }

    override fun onInactive() {
        super.onInactive()
        d { "disposed" }
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }
}