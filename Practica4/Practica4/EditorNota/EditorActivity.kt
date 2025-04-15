/**
 * Actividad para escribir una nota rápida
 * Autor: Jerson
 * Fecha creación: 15/04/2025
 * Última modificación: 15/04/2025
 */
package com.example.practica4_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {
    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button

    // Constante para guardar el estado
    companion object {
        private const val KEY_NOTA = "nota_texto"
    }

    // Registro para el resultado de la actividad OpcionesActivity
    private val opcionesLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Si recibimos RESULT_OK, el usuario quiere seguir editando
            val textoActualizado = result.data?.getStringExtra("nota_editada")
            if (textoActualizado != null) {
                etNota.setText(textoActualizado)
                // Posicionamos el cursor al final del texto
                etNota.setSelection(etNota.text.length)
            }
        }
        // Si es RESULT_CANCELED, el usuario ha compartido la nota y no hacemos nada
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        // Inicialización de vistas
        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)

        // Restaurar el estado si existe
        savedInstanceState?.let {
            etNota.setText(it.getString(KEY_NOTA, ""))
        }

        // Configurar el botón compartir
        btnCompartir.setOnClickListener {
            val textoNota = etNota.text.toString()

            // Solo enviamos la nota si tiene contenido
            if (textoNota.isNotEmpty()) {
                val intent = Intent(this, OpcionesActivity::class.java)
                intent.putExtra("nota", textoNota)
                opcionesLauncher.launch(intent)
            }
        }
    }

    // Guardar el estado si la actividad se destruye (por ejemplo, al rotar la pantalla)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOTA, etNota.text.toString())
    }
}