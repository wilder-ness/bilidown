package com.mh.bilidown.utils

import com.tencent.mmkv.MMKV

object MmkvUtil {
    val kv: MMKV get() = MMKV.defaultMMKV()
}
