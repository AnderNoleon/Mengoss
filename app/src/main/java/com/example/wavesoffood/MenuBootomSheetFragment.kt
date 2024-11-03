package com.example.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adaptar.MenuAdapter
import com.example.wavesoffood.databinding.FragmentMenuBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBootomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBootomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater,container, false)

        binding.buttonBack.setOnClickListener{
            dismiss()
        }


        val menuFoodName = listOf("Burger","sandwich","mono","item","sandwich","mono")
        val menuItemPrice = listOf("Q5","Q6","Q10","Q15","Q10","Q20")
        val menuImage = listOf(
            R.drawable.menu1 ,
            R.drawable.menu2 ,
            R.drawable.menu3 ,
            R.drawable.menu4 ,
            R.drawable.menu5 ,
            R.drawable.menu6)
        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root


    }

    companion object {
    }

}