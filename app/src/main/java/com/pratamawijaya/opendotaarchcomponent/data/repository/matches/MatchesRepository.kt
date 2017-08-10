package com.pratamawijaya.opendotaarchcomponent.data.repository.matches

import android.arch.lifecycle.LiveData
import com.pratamawijaya.opendotaarchcomponent.domain.Matches

/**
 * Created by pratama on 8/10/17.
 */
interface MatchesRepository {
    fun getProMatches(): LiveData<List<Matches>>
}