package com.dreamyprogrammer.spacefromnasa.view.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geekbrains.materialyou.ui.viewpager.EarthFragment
import com.geekbrains.materialyou.ui.viewpager.MarsFragment
import com.geekbrains.materialyou.ui.viewpager.SystemFragment

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), SystemFragment())
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
       return fragments[position]
    }
}