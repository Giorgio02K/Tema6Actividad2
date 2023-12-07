package com.jordichorro.tema6actividad2.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.tema6actividad2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val btnTransferencia = findViewById<Button>(R.id.btn3)

        // Establece un listener para el botón
        btnTransferencia.setOnClickListener {
            // Crea un Intent para abrir la actividad TransferActivity
            val intent = Intent(this, TransferActivity::class.java)
            // Inicia la actividad TransferActivity
            startActivity(intent)
        }

        val btnPosicionGlobal = findViewById<Button>(R.id.btn1)

        // Establece un listener para el botón
        btnPosicionGlobal.setOnClickListener {
            // Crea un Intent para abrir la actividad GlobalPositionActivity
            val intent = Intent(this, GlobalPositionActivity::class.java)
            // Inicia la actividad GlobalPositionActivity
            startActivity(intent)
        }

        val btnMovementsActivity = findViewById<Button>(R.id.btn2)

        // Establece un listener para el botón
        btnMovementsActivity.setOnClickListener {
            // Crea un Intent para abrir la actividad MovementsActivity
            val intent = Intent(this, MovementsActivity::class.java)
            // Inicia la actividad MovementsActivity
            startActivity(intent)
        }
    }
}