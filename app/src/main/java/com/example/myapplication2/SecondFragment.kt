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

class SecondFragment : Fragment() {
    private val viewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val toFirstButton = view.findViewById<Button>(R.id.toFirstFragment)
        val toThirdButton = view.findViewById<Button>(R.id.toThirdFragment)

        toFirstButton.setOnClickListener {
            viewModel.onFirstButtonClicked()
        }

        toThirdButton.setOnClickListener {
            viewModel.onThirdButtonClicked()
        }

        viewModel.navigateToFirst.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
                viewModel.resetNavigation()
            }
        })

        viewModel.navigateToThird.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
                viewModel.resetNavigation()
            }
        })

        return view
    }
}