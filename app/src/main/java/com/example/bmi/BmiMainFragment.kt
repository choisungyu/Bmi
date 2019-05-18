package com.example.bmi


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class BmiMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_bmi_main, container, false)
        val button = view.findViewById<Button>(R.id.button_bmi)

        button.setOnClickListener {
            it.findNavController().navigate(R.id.action_bmiMainFragment_to_bmiMain2Fragment)
        }
        return view

    }
}
