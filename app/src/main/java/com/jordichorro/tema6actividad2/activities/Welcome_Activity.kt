package com.jordichorro.tema6actividad2.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.tema6actividad2.R

class Welcome_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)

        // Obtiene el botón
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        // Establece un listener para el botón
        btnEntrar.setOnClickListener {
            // Crea un Intent para abrir la actividad LoginActivity
            val intent = Intent(this, Login_Activity::class.java)
            // Inicia la actividad LoginActivity
            startActivity(intent)
        }
    }
}
