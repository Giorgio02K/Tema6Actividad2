package com.jordichorro.tema6actividad2.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordichorro.tema6actividad2.R
import com.jordichorro.tema6actividad2.adapter.AdaptadorCuenta
import com.jordichorro.tema6actividad2.bd.MiBancoOperacional
import com.jordichorro.tema6actividad2.pojo.Cliente
import com.jordichorro.tema6actividad2.pojo.Cuenta

class GlobalPositionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtener el cliente del singleton
        val cliente: Cliente? = Login_Activity.ClienteSingleton.cliente

        // Verificar si el cliente no es nulo
        if (cliente != null) {
            // Obtener la lista de cuentas asociadas al cliente
            val listaCuentas: ArrayList<Cuenta>? = MiBancoOperacional.getInstance(this)?.getCuentas(cliente) as ArrayList<Cuenta>?
            val adaptador = AdaptadorCuenta(this, listaCuentas)

            setContentView(R.layout.global_position_activity)

            // Verificar si la lista de cuentas no es nula y no está vacía
            if (!listaCuentas.isNullOrEmpty()) {
                // Obtener el RecyclerView después de inflar la vista
                recyclerView = findViewById(R.id.recyclerCuentas)

                // Ajustar el layout del recyclerView
                recyclerView.layoutManager = LinearLayoutManager(this)

                // Crear el adaptador y configurarlo
                recyclerView.adapter = adaptador
            } else {
                // Lista de cuentas vacía o nula, mostrar un mensaje o manejar según tus necesidades
                Toast.makeText(this, "No hay cuentas asociadas a este cliente", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Cliente nulo, manejar según tus necesidades
            Toast.makeText(this, "Error al obtener los datos del cliente", Toast.LENGTH_SHORT).show()
            finish() // Cerrar la actividad si no hay datos de cliente
        }
    }
}
