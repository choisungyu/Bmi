package com.example.bmi


import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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
            //            val bundle = bundleOf(
//                "height" to edit_text_height.text.toString().toDouble(),
//                "weight" to edit_text_weight.text.toString().toDouble()
//            )
            val edit_text_height = view.findViewById<EditText>(R.id.edit_text_height)
            val edit_text_weight = view.findViewById<EditText>(R.id.edit_text_weight)
//            bundle.putDouble("height", edit_text_height.text.toString().toDouble())
//            bundle.putDouble("height", edit_text_weight.text.toString().toDouble())
            val preference: SharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(requireContext())

            // preference 받아온 것
            val height = preference.getFloat("height", 0f)
            val weight = preference.getFloat("weight", 0f)

            if (height != 0f && weight != 0f) {
                edit_text_height.setText(height.toString())
                edit_text_weight.setText(weight.toString())
            }

            val action = BmiMainFragmentDirections.actionBmiMainFragmentToBmiMain2Fragment(
                edit_text_height.text.toString().toFloat(),
                edit_text_weight.text.toString().toFloat()
            )
            // 확장함수
            toast("hello")

//            it.findNavController().navigate(R.id.action_bmiMainFragment_to_bmiMain2Fragment, bundle)
            it.findNavController().navigate(action)
        }
    }
}
