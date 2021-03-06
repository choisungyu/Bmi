package com.example.bmi


import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_bmi_main2.*


class BmiMain2Fragment : Fragment() {

    private val args: BmiMain2FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bmi_main2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val height = arguments?.getDouble("height")
//        val weight = arguments?.getDouble("weight")

        val bmi = args.weight / Math.pow(args.height / 100.0, 2.0)

        toast("$bmi")

        when {
            bmi >= 35 -> text_view_result.text = "고도비만"
            bmi >= 30 -> text_view_result.text = "2단계비만"
            bmi >= 25 -> text_view_result.text = "1단계비만"
            bmi >= 23 -> text_view_result.text = "과체중"
            bmi >= 18.5 -> text_view_result.text = "정상"
            else -> text_view_result.text = "저체중"
        }

        // ktx 방식
        val preference: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(requireContext())

        preference.edit {
            putFloat("weight",args.weight)
            putFloat("height",args.height)
        }

        // 기존 방식
//        val editor = preference.edit()
//        editor.putFloat("height", args.height)
//            .putFloat("weight", args.weight)
//            .apply()


        Log.d("BmiMain2Fragment", "$args.height, $args.weight")

    }


}
