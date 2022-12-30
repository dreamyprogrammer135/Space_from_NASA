package com.dreamyprogrammer.spacefromnasa.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.dreamyprogrammer.spacefromnasa.databinding.FragmentPictureBinding
import com.dreamyprogrammer.spacefromnasa.viewmodel.AppState
import com.dreamyprogrammer.spacefromnasa.viewmodel.PictureOfTheDayViewModel

class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root
    }


    private val viewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveDate().observe(viewLifecycleOwner) { appState ->
            renderData(appState)
        }
        viewModel.sendRequest()

        binding.chipToday.setOnClickListener {
            Toast.makeText(requireContext(),"chipToday", Toast.LENGTH_SHORT).show()
        }
        binding.chipYesterday.setOnClickListener {
            Toast.makeText(requireContext(),"chipYesterday", Toast.LENGTH_SHORT).show()

        }
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO HW*/
            }
            AppState.Loading -> {/*TODO HW*/
            }
            is AppState.Success -> {
                binding.imageView.load(appState.pictureOfTheDayResponseDate.url) {
                    // TODO HW настроить загрузку изображеня
                    //error()
                    //placeholder()
                }
            }
        }
    }

    companion object {
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}