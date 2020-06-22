package com.mh.bilidown.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class LoginBean (
    val code:Int,//响应码 (0则为正常)
    val expires:Long,//登录标志的有效期 (一般为1个月以后)
    @Json(name = "access_key")
    val accessKey:String?,//得到的登录标志
    val mid:Int,//用户的mid
    val ts:Long//UNIX时间戳
)