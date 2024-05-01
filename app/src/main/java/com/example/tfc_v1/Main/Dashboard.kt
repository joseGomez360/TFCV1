package com.example.tfc_v1.Main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tfc_v1.R

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            private val scheduleList = listOf(
                ScheduleItem("6:00 am", "Levantarse y hacer ejercicio"),
                ScheduleItem("7:00 am", "Desayunar y planificar el día"),
                ScheduleItem("9:00 am", "Trabajar en un proyecto o tarea importante"),
                ScheduleItem("12:00 pm", "Almorzar y tomar un descanso"),
                ScheduleItem("2:00 pm", "Reunión o actividad social"),
                ScheduleItem("4:00 pm", "Hacer ejercicio o practicar un hobby"),
                ScheduleItem("7:00 pm", "Cena y relajarse viendo una película o leyendo un libro")
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}