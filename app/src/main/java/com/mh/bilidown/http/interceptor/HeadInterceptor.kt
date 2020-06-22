package com.mh.bilidown.http.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by guolf on 2017/8/15.
 * @author guolf
 */

class HeadInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authorised = originalRequest.newBuilder()
            .build()

        return chain.proceed(authorised)
    }
}
