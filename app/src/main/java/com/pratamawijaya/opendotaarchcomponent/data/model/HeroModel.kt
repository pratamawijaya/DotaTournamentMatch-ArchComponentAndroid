package com.pratamawijaya.opendotaarchcomponent.data.model

import com.google.gson.annotations.SerializedName

data class HeroModel(
        @SerializedName("primary_attr")
        val primaryAttr: String? = null,
        @SerializedName("attack_type")
        val attackType: String? = null,
        val roles: List<String?>? = null,
        val legs: Int? = null,
        val name: String? = null,
        val id: Int? = null,
        @SerializedName("localized_name")
        val localizedName: String? = null
)
