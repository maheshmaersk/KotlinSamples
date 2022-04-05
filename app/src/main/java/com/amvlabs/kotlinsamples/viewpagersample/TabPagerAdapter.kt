package com.amvlabs.kotlinsamples.viewpagersample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.amvlabs.kotlinsamples.fragmentsample.LoginFragment

class TabPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ChatFragment.newInstance()
            }
            1 -> {
                StatusFragment.newInstance()
            }
            2 -> {
                CallsFragment.newInstance()
            }
            else -> {
                LoginFragment.newInstance()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> {
                "CHAT"
            }
            1 -> {
                "STATUS"
            }
            2 -> {
                "CALLS"
            }
            else -> {
                "LOGIN"
            }
        }
    }
}