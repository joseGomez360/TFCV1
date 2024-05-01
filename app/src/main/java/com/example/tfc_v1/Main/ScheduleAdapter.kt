package com.example.tfc_v1.Main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourapp.R // Replace with your package name

data class ScheduleItem(val time: String, val description: String)

class ScheduleAdapter(private val scheduleList: List<ScheduleItem>) : RecyclerView.Adapter<ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.schedule_item, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = scheduleList[position]
        holder.timeTextView.text = item.time
        holder.descriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }
}

class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val timeTextView: TextView = itemView.findViewById(R.id.time_text_view)
    val descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
}
