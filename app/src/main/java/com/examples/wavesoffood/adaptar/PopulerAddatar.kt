package com.examples.wavesoffood.adaptar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examples.wavesoffood.DetailsActivity
import com.example.wavesoffood.databinding.PopulerItemBinding

class PopulerAddatar (private val items:List<String>, private val price:List<String> ,private val  image: List<Int>, private val requireContext: Context): RecyclerView.Adapter<PopulerAddatar.PouplerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
        return PouplerViewHolder(PopulerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val  price =  price[position]
        holder.bind(item, price,images)

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailsActivity ::class.java)
            intent.putExtra("MenuItemName", item)
            intent.putExtra("MenuItemImage", images)
            requireContext.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return  items.size

    }


    class PouplerViewHolder (private val binding : PopulerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageView6
        fun bind(item: String, price: String,images: Int) {
            binding.foodNamePopuler.text = item
            binding.pricePopuler.text = price
            imagesView.setImageResource(images)

        }


    }

}