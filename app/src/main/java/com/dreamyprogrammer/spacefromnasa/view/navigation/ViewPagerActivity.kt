package com.dreamyprogrammer.spacefromnasa.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}