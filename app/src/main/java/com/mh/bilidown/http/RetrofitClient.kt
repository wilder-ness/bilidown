package com.mh.bilidown.http

import com.mh.bilidown.BuildConfig
import com.mh.bilidown.http.interceptor.HeadInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by guolf on 2017/6/16.
 *
 * @author guolf
 */

object RetrofitClient {
    private const val BASE_URL = "http://api.bilibili.com/"
    private const val CONNECT_TIMEOUT: Long = 60
    private const val READ_TIMEOUT: Long = 120
    private const val WRITE_TIMEOUT: Long = 120

    private val okHttpClient by lazy {
        val builder = OkHttpClient().newBuilder()
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(HeadInterceptor())
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        builder.build()
    }
    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create()
            )
            .build().create(ApiService::class.java)
    }

}
