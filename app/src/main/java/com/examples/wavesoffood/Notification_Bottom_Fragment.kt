package com.examples.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.examples.wavesoffood.adaptar.NotificationAdapter
import com.example.wavesoffood.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class Notification_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notifications = listOf("Tu orden ha sido cancelado lastimosamente", "La orden esta en camino","Gracias por ordenar")
        val notificationImages = listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congratulations)
        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}