package com.jordichorro.tema6actividad2.activities

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.tema6actividad2.R
import com.jordichorro.tema6actividad2.adapter.SpinnerAdapter
import com.jordichorro.tema6actividad2.bd.MiBancoOperacional
import com.jordichorro.tema6actividad2.pojo.Cliente

class MovementsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.movements_activity)
        val cliente: Cliente? = Login_Activity.ClienteSingleton.cliente

        val spinner = findViewById<Spinner>(R.id.spinnerCuentas)
        spinner.adapter = SpinnerAdapter(this, MiBancoOperacional.getInstance(this)?.getCuentas(cliente))
    }






}