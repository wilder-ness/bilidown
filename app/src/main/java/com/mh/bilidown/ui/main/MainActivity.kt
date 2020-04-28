package com.mh.bilidown.ui.main

import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mh.bilidown.R
import com.mh.bilidown.base.BaseActivity
import com.mh.bilidown.view.VpFragmentStateAdapter
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity(override val layoutResId: Int = R.layout.main_activity) : BaseActivity() {
    private val fragments: ArrayList<Fragment> = ArrayList()

    override fun initView() {
        fragments.add(MeFragment.newInstance())
        fragments.add(MeFragment.newInstance())
        fragments.add(MeFragment.newInstance())
        mTab.addTab(mTab.newTab())
        mTab.addTab(mTab.newTab())
        mTab.addTab(mTab.newTab())
        mVp.adapter = VpFragmentStateAdapter(fragments, this)
        mVp.isUserInputEnabled = false
        mVp.offscreenPageLimit = fragments.size
        TabLayoutMediator(mTab, mVp, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = when (position) {
                0 -> "解析"
                1 -> "下载"
                else -> "我的"
            }
        }).attach()
    }
}