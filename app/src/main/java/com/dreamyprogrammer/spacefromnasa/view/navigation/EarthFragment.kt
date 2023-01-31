package com.geekbrains.materialyou.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dreamyprogrammer.spacefromnasa.R
import com.dreamyprogrammer.spacefromnasa.databinding.FragmentEarthBinding
import com.dreamyprogrammer.spacefromnasa.view.navigation.ViewPager2AdapterForEarthFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class EarthFragment : Fragment() {


    private var _binding: FragmentEarthBinding? = null
    private val binding get() = _binding!!

    //    val nameFragments = arrayOf("Сегодня", "Вчера")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameFragments =
            arrayOf(resources.getString(R.string.today), resources.getString(R.string.yesterday))

        binding.viewPager.adapter = ViewPager2AdapterForEarthFragment(this)
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    tab.text = nameFragments[position]
                }
            }).attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
