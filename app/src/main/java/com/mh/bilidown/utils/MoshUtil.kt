package com.mh.bilidown.utils

import com.squareup.moshi.Moshi

object MoshUtil {
    val moshi: Moshi get() = Moshi.Builder().build()
}