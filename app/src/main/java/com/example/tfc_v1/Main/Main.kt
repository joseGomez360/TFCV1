import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc_v1.Main.ResetPasswordActivity
import com.example.tfc_v1.Main.ScheduleAdapter
import com.example.tfc_v1.Main.ScheduleItem

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

        val forgotPasswordText = findViewById<TextView>(R.id.forgot_password_text)
        forgotPasswordText.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}

class ScheduleItem(val time: String, val description: String) {
    // Puedes agregar métodos u otras propiedades aquí si es necesario
}
