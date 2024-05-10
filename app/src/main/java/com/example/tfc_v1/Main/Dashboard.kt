package com.example.tfc_v1.Main

import ScheduleItem
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc_v1.R

class Dashboard : AppCompatActivity() {

    private val scheduleList = mutableListOf<ScheduleItem>() // Lista mutable para almacenar los elementos

    private lateinit var scheduleAdapter: ScheduleAdapter // Adaptador para el RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val recyclerViewSchedule = findViewById<RecyclerView>(R.id.recycler_view_schedule)

        // Inicializar el adaptador con la lista de elementos
        scheduleAdapter = ScheduleAdapter(scheduleList)
        recyclerViewSchedule.adapter = scheduleAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addItemButton = findViewById<Button>(R.id.add_item_button)
        addItemButton.setOnClickListener {
            showAddItemDialog()
        }
    }

    private fun showAddItemDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Añadir Nuevo Elemento")
        alertDialog.setMessage("Ingresa la hora y la descripción del nuevo elemento")

        val inputLayout = LinearLayout(this)
        inputLayout.orientation = LinearLayout.VERTICAL

        val inputTime = EditText(this)
        inputTime.hint = "Hora (por ejemplo, 6:00 am)"
        inputLayout.addView(inputTime)

        val inputDescription = EditText(this)
        inputDescription.hint = "Descripción"
        inputLayout.addView(inputDescription)

        alertDialog.setView(inputLayout)

        alertDialog.setPositiveButton("Añadir") { _, _ ->
            val time = inputTime.text.toString()
            val description = inputDescription.text.toString()

            // Crear un nuevo elemento y agregarlo a la lista
            val newItem = ScheduleItem(time, description)
            scheduleList.add(newItem)

            // Notificar al adaptador que se ha agregado un nuevo elemento
            scheduleAdapter.notifyDataSetChanged()
        }

        alertDialog.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        alertDialog.show()
    }
}


