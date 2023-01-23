package com.dreamyprogrammer.spacefromnasa.view.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.geekbrains.materialyou.ui.viewpager.EarthFragment
import com.geekbrains.materialyou.ui.viewpager.MarsFragment
import com.geekbrains.materialyou.ui.viewpager.WeatherFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), WeatherFragment())

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    //    private val fragments = arrayOf(EarthFragment(), MarsFragment(), WeatherFragment())
//
//    override fun createFragment(position: Int): Fragment {
//        return when (position) {
//            0 -> fragments[EARTH_FRAGMENT]
//            1 -> fragments[MARS_FRAGMENT]
//            2 -> fragments[WEATHER_FRAGMENT]
//            else -> fragments[EARTH_FRAGMENT]
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return fragments.size
//    }
//
//    companion object {
//        private const val EARTH_FRAGMENT = 0
//        private const val MARS_FRAGMENT = 1
//        private const val WEATHER_FRAGMENT = 2
//    }

}
