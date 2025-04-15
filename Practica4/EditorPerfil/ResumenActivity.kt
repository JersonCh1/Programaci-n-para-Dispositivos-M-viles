package com.example.practica4_1

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {
    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvCiudad: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnEditar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // Inicialización de vistas
        tvNombre = findViewById(R.id.tvNombre)
        tvEdad = findViewById(R.id.tvEdad)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvCorreo = findViewById(R.id.tvCorreo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnEditar = findViewById(R.id.btnEditar)

        // Obtener el objeto Usuario de los extras del intent
        val usuario = if (android.os.Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("usuario", FormularioActivity.Usuario::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<FormularioActivity.Usuario>("usuario")
        }

        // Mostrar los datos en los TextViews
        usuario?.let {
            tvNombre.text = "Nombre: ${it.nombre}"
            tvEdad.text = "Edad: ${it.edad}"
            tvCiudad.text = "Ciudad: ${it.ciudad}"
            tvCorreo.text = "Correo: ${it.correo}"
        }

        // Configurar el botón de confirmar
        btnConfirmar.setOnClickListener {
            // El usuario confirma la información
            setResult(Activity.RESULT_OK)
            finish()
        }

        // Configurar el botón de editar
        btnEditar.setOnClickListener {
            // El usuario quiere volver a editar
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}