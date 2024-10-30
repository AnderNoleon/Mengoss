package com.example.wavesoffood.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.FragmentNotificationBottomBinding
import com.example.wavesoffood.databinding.NotificationItemBinding

class NotificationAdapter(private var notification : ArrayList<String>,private var notificationImage : ArrayList<Int>) : RecyclerView.Adapter<NotificationAdapter.NotifificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifificationViewHolder {

        val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotifificationViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NotifificationViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = notification.size

    inner class NotifificationViewHolder(private val binding: NotificationItemBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notificationTextView.text = notification[position]
                notificationImageView.setImageResource(notificationImage[position])
            }
        }

    }

}