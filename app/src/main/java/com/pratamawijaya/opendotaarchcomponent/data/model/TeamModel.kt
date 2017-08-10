package com.pratamawijaya.opendotaarchcomponent.data.model

import com.google.gson.annotations.SerializedName

data class TeamModel(
        val name: String? = null,
        @SerializedName("team_id")
        val teamId: Int? = null,
        val tag: String? = null
)
