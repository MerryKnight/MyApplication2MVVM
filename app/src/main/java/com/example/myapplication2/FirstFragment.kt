package com.example.myapplication2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {
    private val viewModel: FirstViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val toSecondButton = view.findViewById<Button>(R.id.buttonToSecondFragment)
        val toThirdButton = view.findViewById<Button>(R.id.buttonToThirdFragment)

        // Связываем кнопки с методами ViewModel
        toSecondButton.setOnClickListener {
            viewModel.onSecondButtonClicked()
        }

        toThirdButton.setOnClickListener {
            viewModel.onThirdButtonClicked()
        }

        // Наблюдаем за событиями навигации
        viewModel.navigateToSecond.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                viewModel.resetNavigation()
            }
        })

        viewModel.navigateToThird.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
                viewModel.resetNavigation()
            }
        })

        return view
    }
}