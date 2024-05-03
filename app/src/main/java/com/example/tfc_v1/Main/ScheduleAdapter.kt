package com.example.tfc_v1.Main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc_v1.R
import com.example.tfc_v1.Main.ScheduleItem


class ScheduleAdapter(private val scheduleList: List<ScheduleItem>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timeTextView: TextView = itemView.findViewById(R.id.text_time)
        val descriptionTextView: TextView = itemView.findViewById(R.id.text_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = scheduleList[position]
        holder.timeTextView.text = item.time
        holder.descriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }
}