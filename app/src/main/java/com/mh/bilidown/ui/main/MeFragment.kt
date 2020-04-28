package com.mh.bilidown.ui.main

import com.mh.bilidown.base.BaseFragment
import com.mh.bilidown.R

class MeFragment : BaseFragment() {
    override val layoutResId: Int= R.layout.me
    override fun initView() {
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}