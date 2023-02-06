package com.dreamyprogrammer.spacefromnasa.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.dreamyprogrammer.spacefromnasa.databinding.FragmentPictureBinding
import com.dreamyprogrammer.spacefromnasa.viewmodel.AppState
import com.dreamyprogrammer.spacefromnasa.viewmodel.PictureOfTheDayViewModel

private const val ARG_PARAM1 = "param1"

class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureBinding? = null
    private val binding get() = _binding!!
    private var param1: Int? = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root

        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }


    private val viewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.textInputLayout.setEndIconOnClickListener{
//            startActivity(Intent(Intent.ACTION_VIEW).apply {
//                data = Uri.parse("https://ru.wikipedia.org/wiki/${binding.textInput.text.toString()}")
//            })
//        }


        viewModel.getLiveDate().observe(viewLifecycleOwner) { appState ->
            renderData(appState)
        }

        viewModel.sendRequest(arguments?.getInt(ARG_PARAM1)!!);
//        viewModel.sendRequest(param1)

//        binding.chipToday.setOnClickListener {
//            Toast.makeText(requireContext(),"chipToday", Toast.LENGTH_SHORT).show()
//        viewModel.sendRequest(param1);
//        }
//        binding.chipYesterday.setOnClickListener {
//            Toast.makeText(requireContext(),"chipYesterday", Toast.LENGTH_SHORT).show()
//            viewModel.sendRequest(2);
//        }
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
                binding.explanation.text =
                    appState.pictureOfTheDayResponseDate.explanation.toString()
            }
        }
    }

    companion object {
        fun newInstance(param1: Int) = PictureOfTheDayFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_PARAM1, param1)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}