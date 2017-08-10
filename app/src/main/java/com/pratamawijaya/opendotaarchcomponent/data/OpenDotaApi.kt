package com.pratamawijaya.opendotaarchcomponent.data

import com.pratamawijaya.opendotaarchcomponent.data.model.HeroModel
import com.pratamawijaya.opendotaarchcomponent.data.model.LeagueModel
import com.pratamawijaya.opendotaarchcomponent.data.model.MatchesModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by pratama on 8/10/17.
 */
interface OpenDotaApi {

    @GET("proMatches")
    fun getProMatches(): Observable<List<MatchesModel>>

    @GET("leagues")
    fun getLeagues(): Observable<List<LeagueModel>>

    @GET("matches/{match_id}")
    fun getMatches(@Path("match_id") id: Long)

    @GET("heroes")
    fun getHeroues(): Observable<List<HeroModel>>
}