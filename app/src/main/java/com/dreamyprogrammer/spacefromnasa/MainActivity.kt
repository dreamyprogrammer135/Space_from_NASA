package com.dreamyprogrammer.spacefromnasa

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityMainBinding
import com.dreamyprogrammer.spacefromnasa.view.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    //    setTheme(R.style.IndigoTheme)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }

    }
}