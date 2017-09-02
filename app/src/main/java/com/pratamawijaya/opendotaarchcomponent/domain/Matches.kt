package com.pratamawijaya.opendotaarchcomponent.domain

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by pratama on 8/10/17.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class Matches(val id: Long? = null,
                   val leagueName: String? = null,
                   val direName: String? = null,
                   val radiantName: String? = null,
                   val duration: Int? = null) : Parcelable