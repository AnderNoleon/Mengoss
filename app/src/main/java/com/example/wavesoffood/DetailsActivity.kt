package com.example.wavesoffood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wavesoffood.databinding.ActivityDetailsBinding
import com.example.wavesoffood.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage", 0 )
        binding.detailFoodName.text = foodName
        binding.DetailFoodImageView.setImageResource(foodImage)

        binding.imageButton.setOnClickListener{
            finish()
        }
    }
}