package com.dreamyprogrammer.spacefromnasa.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityRecyclerItemEarthBinding
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityRecyclerItemHeaderBinding
import com.dreamyprogrammer.spacefromnasa.databinding.ActivityRecyclerItemMarsBinding


class RecyclerAdapter(
    private var lastData: MutableList<Data>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return lastData[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Data.TYPE_EARTH -> {
                val binding =
                    ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(binding)
            }
            Data.TYPE_MARS -> {
                val binding =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(binding)
            }
            else -> {
                val binding =
                    ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context))
                HeaderViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return lastData.size
    }

    class MarsViewHolder(binding: ActivityRecyclerItemMarsBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    class EarthViewHolder(binding: ActivityRecyclerItemEarthBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    class HeaderViewHolder(binding: ActivityRecyclerItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}