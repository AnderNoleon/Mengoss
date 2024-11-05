package com.examples.wavesoffood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.examples.wavesoffood.MenuBootomSheetFragment

import com.example.wavesoffood.R
import com.examples.wavesoffood.adaptar.PopulerAddatar
import com.example.wavesoffood.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container,false)

        binding.viewAllMenu.setOnClickListener{
            val bottomSheetDialog = MenuBootomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")


        }
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPositon = imageList[position]
                val itemMessage = "Selected Image   $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Burger", "Sandwinch", "Momo", "item")
        val Price = listOf("Q5","Q7","Q10","Q20")
        val populerFoodImage=
            listOf(R.drawable.menu1, R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)
        val adapter = PopulerAddatar(foodName,Price,populerFoodImage, requireContext())
        binding.PopulerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopulerRecyclerView.adapter = adapter


    }
}