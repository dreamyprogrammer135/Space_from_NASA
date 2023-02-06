package com.dreamyprogrammer.spacefromnasa.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dreamyprogrammer.spacefromnasa.R
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityBottomBarBinding
import com.geekbrains.materialyou.ui.viewpager.EarthFragment
import com.geekbrains.materialyou.ui.viewpager.MarsFragment
import com.geekbrains.materialyou.ui.viewpager.SystemFragment

class BottomBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_view_earth -> {navigationTo(EarthFragment())}
                R.id.action_view_mars -> {navigationTo(MarsFragment())}
                R.id.action_view_system -> {navigationTo(SystemFragment())}
            }
            true
        }

        binding.bottomNavigationView.selectedItemId = R.id.action_view_earth
    }

    fun navigationTo(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}