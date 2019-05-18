package com.example.bmi


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_bmi_main.*

class BmiMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //        val button = view.findViewById<Button>(R.id.button_bmi)

        return inflater.inflate(R.layout.fragment_bmi_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_bmi.setOnClickListener {
            val bundle = Bundle()
            bundle.putDouble("height", edit_text_height.text.toString().toDouble())
            bundle.putDouble("height", edit_text_weight.text.toString().toDouble())

            it.findNavController().navigate(R.id.action_bmiMainFragment_to_bmiMain2Fragment, bundle)
        }
    }
}
