package com.mh.bilidown.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class UserInfo(
    val name: String?,
    @Json(name = "access_key")
    val accessKey: String?,
    @Json(name = "access_key")
    val expiredTime: String?,
    val photo: String?,
    val mid: Int,
    val isVip: Boolean
) : Parcelable