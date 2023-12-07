package com.jordichorro.tema6actividad2.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jordichorro.tema6actividad2.R
import com.jordichorro.tema6actividad2.pojo.Cuenta

class AdaptadorCuenta(private val context: Context, private val listaCuentas: List<Cuenta>?) :
    RecyclerView.Adapter<AdaptadorCuenta.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("AdaptadorCuenta", "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_cuenta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("AdaptadorCuenta", "onBindViewHolder: $position")
        val cuenta = listaCuentas?.get(position)
        holder.bind(cuenta)
    }

    override fun getItemCount(): Int {
        return listaCuentas?.size ?: 0
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNumeroCuenta: TextView = itemView.findViewById(R.id.tvNumeroCuenta)
        private val tvSaldoActual: TextView = itemView.findViewById(R.id.tvSaldoActual)

        fun bind(cuenta: Cuenta?) {
            tvNumeroCuenta.text = "Cuenta: " + cuenta?.getNumeroCuenta()

            val saldoActual = cuenta?.getSaldoActual() ?: 0.0
            val saldoText = "Saldo: ${saldoActual}"

            tvSaldoActual.text = saldoText
        }
    }


}
