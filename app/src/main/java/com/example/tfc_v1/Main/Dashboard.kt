package com.example.tfc_v1.Main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc_v1.R

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val recyclerViewSchedule = findViewById<RecyclerView>(R.id.recycler_view_schedule)

        val scheduleList = listOf(
            ScheduleItem("6:00 am", "Levantarse y hacer ejercicio"),
            ScheduleItem("7:00 am", "Desayunar y planificar el día"),
            ScheduleItem("9:00 am", "Trabajar en un proyecto o tarea importante"),
            ScheduleItem("12:00 pm", "Almorzar y tomar un descanso"),
            ScheduleItem("2:00 pm", "Reunión o actividad social"),
            ScheduleItem("4:00 pm", "Hacer ejercicio o practicar un hobby"),
            ScheduleItem("7:00 pm", "Cena y relajarse viendo una película o leyendo un libro")
        )

        recyclerViewSchedule.adapter = ScheduleAdapter(scheduleList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButtonTopCenter = findViewById<ImageButton>(R.id.image_button_top_center)
        imageButtonTopCenter.setOnClickListener {

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            // O si estás en un fragmento, puedes cargar nuevamente el fragmento actual:
            // fragmentManager.beginTransaction().replace(R.id.fragment_container, MyFragment()).commit()
        }
    }
}
