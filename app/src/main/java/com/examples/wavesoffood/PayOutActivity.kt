package com.examples.wavesoffood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wavesoffood.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.PlaceMyOrden.setOnClickListener {
            val bottomSheetDialog = CongrantsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}