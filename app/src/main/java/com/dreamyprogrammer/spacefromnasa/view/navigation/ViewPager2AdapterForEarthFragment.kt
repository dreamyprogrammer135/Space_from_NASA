package com.dreamyprogrammer.spacefromnasa.view.navigation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dreamyprogrammer.spacefromnasa.view.PictureOfTheDayFragment

class ViewPager2AdapterForEarthFragment(fr: Fragment) :
    FragmentStateAdapter(fr) {

    private val fragments =
        arrayOf(PictureOfTheDayFragment.newInstance(1), PictureOfTheDayFragment.newInstance(2))

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}