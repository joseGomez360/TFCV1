package com.example.tfc_v1.Main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main : AppCompatActivity() {

    private val scheduleList = listOf(
        ScheduleItem("6:00 am", "Levantarse y hacer ejercicio"),
        ScheduleItem("7:00 am", "Desayunar y planificar el día"),
        ScheduleItem("9:00 am", "Trabajar en un proyecto o tarea importante"),
        ScheduleItem("12:00 pm", "Almorzar y tomar un descanso"),
        ScheduleItem("2:00 pm", "Reunión o actividad social"),
        ScheduleItem("4:00 pm", "Hacer ejercicio o practicar un hobby"),
        ScheduleItem("7:00 pm", "Cena y relajarse viendo una película o leyendo un libro")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.text_list_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ScheduleAdapter(scheduleList)
    }
}