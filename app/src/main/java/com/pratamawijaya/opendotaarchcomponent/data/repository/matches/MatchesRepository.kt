package com.pratamawijaya.opendotaarchcomponent.data.repository.matches

import com.pratamawijaya.opendotaarchcomponent.domain.Matches
import io.reactivex.Single

/**
 * Created by pratama on 8/10/17.
 */
interface MatchesRepository {
    fun getProMatches(): Single<List<Matches>>
}