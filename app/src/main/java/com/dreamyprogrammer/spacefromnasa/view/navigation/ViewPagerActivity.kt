package com.dreamyprogrammer.spacefromnasa.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding
    val nameFragments = arrayOf("Земля", "Марс", "Погода")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPager2Adapter(this)
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    tab.text = nameFragments[position]
                }
            }).attach()
//        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}
