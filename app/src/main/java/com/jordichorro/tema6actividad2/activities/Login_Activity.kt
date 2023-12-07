package com.jordichorro.tema6actividad2.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.tema6actividad2.R
import com.jordichorro.tema6actividad2.bd.MiBancoOperacional
import com.jordichorro.tema6actividad2.pojo.Cliente


class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        //Se obtiene la señal del boton
        val btnEntrar = findViewById<Button>(R.id.btnIniciar)

        //Obtener el usuario y la contraseña introducidos por teclado
        val usuario = findViewById<EditText>(R.id.usuarioInp)
        val contrasenya = findViewById<EditText>(R.id.passwordInp)

        btnEntrar.setOnClickListener {
            //Se pasa los datos de usuario y contrasenya a la variable cliente
            val cliente = Cliente()
            cliente.setNif(usuario.text.toString())
            cliente.setClaveSeguridad(contrasenya.text.toString())


            try {
                val comprobar: Cliente = MiBancoOperacional.getInstance(this)?.login(cliente) ?: Cliente()

                if (comprobar != null) {
                    ClienteSingleton.cliente = comprobar
                    val intent = Intent(this, MainActivity::class.java)
                    // Se inicia la nueva actividad
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Usuario o contrasenya incorrectos", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Se muestra un mensaje de error
                Toast.makeText(this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            }
        }
    }
    object ClienteSingleton {
        var cliente: Cliente? = null
    }

}
