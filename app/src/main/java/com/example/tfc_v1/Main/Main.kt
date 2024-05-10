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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val scheduleList = listOf(
            ScheduleItem("6:00 am", "Levantarse y hacer ejercicio"),
            ScheduleItem("7:00 am", "Desayunar y planificar el día"),
            ScheduleItem("9:00 am", "Trabajar en un proyecto o tarea importante"),
            ScheduleItem("12:00 pm", "Almorzar y tomar un descanso"),
            ScheduleItem("2:00 pm", "Reunión o actividad social"),
            ScheduleItem("4:00 pm", "Hacer ejercicio o practicar un hobby"),
            ScheduleItem("7:00 pm", "Cena y relajarse viendo una película o leyendo un libro")
        )

        // Referenciar elementos
        val usernameField = findViewById(R.id.username_field)
        val passwordField = findViewById(R.id.password_field)
        val loginButton = findViewById(R.id.login_button)
        private val validUsername = "usuario_correcto"
        private val validPassword = "contraseña_correcta"

        fun navigateToMainScreen() {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        private fun validateCredentials(username: String, password: String) {
            if (username == validUsername && password == validPassword) {
                // Credenciales válidas, navegar a la pantalla principal
                navigateToMainScreen()
            } else {
                // Credenciales inválidas, mostrar mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            // Validar credenciales (ver paso 3)
            validateCredentials(username, password)
        }

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
