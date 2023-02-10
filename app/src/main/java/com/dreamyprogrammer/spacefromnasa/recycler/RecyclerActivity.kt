package com.dreamyprogrammer.spacefromnasa.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = arrayListOf(
            Data("Mars", "",3),
            Data("Mars", "",1),
            Data("Mars", "",2),
            Data("Mars", "",2),
            Data("Mars", "",1),
            Data("Mars", "",2),
            Data("Mars", "",2),
            Data("Mars", "",1),
            Data("Mars", "",2),
            Data("Mars", "",3),
            Data("Mars", "",1),
            Data("Mars", "",2),
            Data("Mars", "",3),
            Data("Mars", "",1),
            Data("Mars", "",2),
            Data("Mars", "",2),
            Data("Mars", "",2)
        )

        binding.recyclerView.adapter = RecyclerAdapter(data)
    }
}