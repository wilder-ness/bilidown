package com.mh.bilidown.http

import com.mh.bilidown.model.KeyBean
import com.mh.bilidown.model.LoginBean
import retrofit2.http.GET

/**
 * Created by guolf on 2017/6/16.
 *
 * @author guolf
 */

interface ApiService {

    @GET("https://passport.bilibili.com/login?act=getkey")
    suspend fun getKey(): KeyBean?//登录接口

    @GET("https://account.bilibili.com/api/login/v2")
    suspend fun login(): LoginBean
}


