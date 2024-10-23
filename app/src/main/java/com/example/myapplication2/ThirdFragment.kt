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

class ThirdFragment : Fragment() {
    private val viewModel: ThirdViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val toFirstButton = view.findViewById<Button>(R.id.toFirstFragment)
        val toSecondButton = view.findViewById<Button>(R.id.toSecondFragment)

        toFirstButton.setOnClickListener {
            viewModel.onFirstButtonClicked()
        }

        toSecondButton.setOnClickListener {
            viewModel.onSecondButtonClicked()
        }

        viewModel.navigateToFirst.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
                viewModel.resetNavigation()
            }
        })

        viewModel.navigateToSecond.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
                viewModel.resetNavigation()
            }
        })

        return view
    }
}