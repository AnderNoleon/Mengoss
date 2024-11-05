package com.examples.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.examples.wavesoffood.adaptar.MenuAdapter

import com.example.wavesoffood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val orignalMenuFoodName = listOf("Burger","Cebollines","Chalupa","Shuko","Megas burgers ","Para la familia")
    private val originalmenuItemPrice = listOf("Q55","Q46","Q15","Q36","Q245","Q109")
    private val originalmenuImage = listOf(
        R.drawable.burger1 ,
        R.drawable.cebolline ,
        R.drawable.chulapa ,
        R.drawable.debage ,
        R.drawable.menu5 ,
        R.drawable.menu6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)


        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter


        //set up buscade view
        setupSearchView()

        //show alla
        showAllMenu()
        return binding.root

    }

    private fun showAllMenu() {

        filteredMenuImage.clear()
        filteredMenuItemPrice.clear()
        filteredMenuFoodName.clear()
        filteredMenuFoodName.addAll(orignalMenuFoodName)
        filteredMenuItemPrice.addAll(originalmenuItemPrice)
        filteredMenuImage.addAll(originalmenuImage)

        adapter.notifyDataSetChanged()


    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true


            }


        })



    }

    private fun filterMenuItems(query: String) {
        filteredMenuImage.clear()
        filteredMenuItemPrice.clear()
        filteredMenuFoodName.clear()

        orignalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true))
            {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalmenuItemPrice[index])
                filteredMenuImage.add(originalmenuImage[index])

            }
        }

        adapter.notifyDataSetChanged()

    }


    companion object {
    }

}


