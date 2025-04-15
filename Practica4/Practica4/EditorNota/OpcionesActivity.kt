/**
 * Actividad para mostrar opciones de compartir o editar una nota
 * Autor: Jerson
 * Fecha creación: 15/04/2025
 * Última modificación: 15/04/2025
 */
package com.example.practica4_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {
    private lateinit var tvNota: TextView
    private lateinit var btnCompartirCorreo: Button
    private lateinit var btnEditarNuevo: Button
    private var textoNota: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        // Inicialización de vistas
        tvNota = findViewById(R.id.tvNota)
        btnCompartirCorreo = findViewById(R.id.btnCompartirCorreo)
        btnEditarNuevo = findViewById(R.id.btnEditarNuevo)

        // Obtener el texto de la nota del intent
        textoNota = intent.getStringExtra("nota") ?: ""
        tvNota.text = textoNota

        // Configurar el botón de compartir por correo
        btnCompartirCorreo.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
            // Indicamos que la operación ha sido cancelada (no queremos volver a editar)
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        // Configurar el botón de editar de nuevo
        btnEditarNuevo.setOnClickListener {
            // Preparamos el intent de respuesta con el texto actual de la nota
            val intentRespuesta = Intent()
            intentRespuesta.putExtra("nota_editada", textoNota)
            setResult(Activity.RESULT_OK, intentRespuesta)
            finish()
        }
    }
}