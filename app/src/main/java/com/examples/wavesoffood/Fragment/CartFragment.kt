package com.examples.wavesoffood.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.wavesoffood.PayOutActivity
import com.example.wavesoffood.R
import com.examples.wavesoffood.adaptar.CartAdapter
import com.example.wavesoffood.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Burger","Cebollines","Chalupa","Shuko","Megas burgers ","Para la familia")
        val cartItemPrice = listOf("Q55","Q46","Q15","Q36","Q245","Q109")
        val cartImage = listOf(
            R.drawable.burger1 ,
            R.drawable.cebolline ,
            R.drawable.chulapa ,
            R.drawable.debage ,
            R.drawable.menu5 ,
            R.drawable.menu6)
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter


        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity ::class.java)
            startActivity(intent)
        }




        return binding.root
    }

    companion object {

    }
}