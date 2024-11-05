package com.examples.wavesoffood

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wavesoffood.databinding.FragmentCongrantsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongrantsBottomSheet : BottomSheetDialogFragment() {
    private  lateinit var binding: FragmentCongrantsBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCongrantsBottomSheetBinding.inflate(layoutInflater,container,false)
        binding.goHome.setOnClickListener{
            val intent = Intent(requireContext(),MainActivity ::class.java)
            //  Se dirige al menu principal
            startActivity(intent)

            // login
            // val intent = Intent(requireContext(),SignActivity ::class.java)
            // startActivity(intent)

        }
        return binding.root
    }

    companion object {

    }
}