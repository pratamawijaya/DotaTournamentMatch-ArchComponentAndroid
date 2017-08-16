package com.pratamawijaya.opendotaarchcomponent.data.repository.matches

import com.pratamawijaya.opendotaarchcomponent.data.OpenDotaApi
import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by pratama on 8/10/17.
 */
class MatchesRepositoryImpl @Inject constructor(private val services: OpenDotaApi) : MatchesRepository {

    override fun getProMatches(): Single<List<Matches>> {
        return services.getProMatches()
                .flatMap { Observable.fromIterable(it) }
                .map {
                    Matches(id = it.matchId,
                            direName = it.direName,
                            duration = it.duration,
                            leagueName = it.leagueName,
                            radiantName = it.radiantName)
                }.toList()
    }
}