package com.mh.bilidown.ui.main

import android.content.Intent
import com.mh.bilidown.R
import com.mh.bilidown.base.BaseFragment
import com.mh.bilidown.constants.KvConstants
import com.mh.bilidown.model.UserInfo
import com.mh.bilidown.ui.login.LoginActivity
import com.mh.bilidown.utils.MmkvUtil
import com.mh.bilidown.utils.MoshUtil
import kotlinx.android.synthetic.main.me.*

class MeFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.me
    private val userInfo: UserInfo? by lazy {
        val json = MmkvUtil.kv.getString(KvConstants.USER_INFO, null)
        if (!json.isNullOrEmpty()) {
            MoshUtil.moshi.adapter(UserInfo::class.java).fromJson(json)
        } else null
    }

    override fun initView() {
        if (userInfo == null) {
            mLogin.text = userInfo?.name
        } else {

        }

        mLogin.setOnClickListener {
            if (userInfo == null) {
                startActivity(Intent(mActivity, LoginActivity::class.java))
            } else {

            }
        }
    }

    companion object {
        fun newInstance() = MeFragment()
    }
}