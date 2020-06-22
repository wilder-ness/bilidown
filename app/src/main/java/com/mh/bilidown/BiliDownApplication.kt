package com.mh.bilidown

import android.app.Application
import com.tencent.mmkv.MMKV

class BiliDownApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}