package com.mh.bilidown.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VpFragmentStateAdapter(val fragments: List<Fragment>, activity: FragmentActivity) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}