package com.examples.wavesoffood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var NavController = findNavController(R.id.fragmentContainerView)
        var bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationView3)
        bottomnav.setupWithNavController(NavController)

       binding.notificationButton.setOnClickListener{
           val bottomSheDialog = Notification_Bottom_Fragment()
           bottomSheDialog.show(supportFragmentManager,"test")

       }

    }
}