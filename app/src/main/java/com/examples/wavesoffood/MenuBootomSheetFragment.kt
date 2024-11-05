package com.examples.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.examples.wavesoffood.adaptar.MenuAdapter
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


        val menuFoodName = listOf("Burger","Cebollines","Chalupa","Shuko","Megas burgers ","Para la familia","Tocino rico")
        val menuItemPrice = listOf("Q55","Q46","Q15","Q36","Q245","Q109","Q65")
        val menuImage = listOf(
            R.drawable.burger1 ,
            R.drawable.cebolline ,
            R.drawable.chulapa ,
            R.drawable.debage ,
            R.drawable.menu5 ,
            R.drawable.menu6,
            R.drawable.tocino)
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