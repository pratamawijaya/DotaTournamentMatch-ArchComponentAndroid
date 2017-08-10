package com.pratamawijaya.opendotaarchcomponent.data.model

import com.google.gson.annotations.SerializedName

data class MatchesModel(
        val duration: Int? = null,
        @SerializedName("start_time")
        val startTime: Int? = null,
        @SerializedName("radiant_name")
        val radiantName: String? = null,
        @SerializedName("radiant_win")
        val radiantWin: Boolean? = null,
        @SerializedName("dire_name")
        val direName: String? = null,
        val leagueid: Int? = null,
        @SerializedName("match_id")
        val matchId: Long? = null,
        @SerializedName("league_name")
        val leagueName: String? = null,
        @SerializedName("radiant_team_id")
        val radiantTeamId: Int? = null,
        val seriesType: Int? = null,
        @SerializedName("dire_team_id")
        val direTeamId: Int? = null,
        @SerializedName("series_id")
        val seriesId: Int? = null
)
