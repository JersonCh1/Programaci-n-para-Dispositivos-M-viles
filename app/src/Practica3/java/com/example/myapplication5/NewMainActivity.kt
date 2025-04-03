/*
 * Descripción: Aplicación que muestra una imagen y muestra un Toast al hacer clic en ella
 * Autor: Tu nombre
 * Fecha creación: 27/03/2025
 * Última modificación: 27/03/2025
 */

package com.example.myapplication5 // Asegúrate de cambiar esto a tu nombre de paquete real

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class NewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_main)

        // Obtenemos referencia a la imagen
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Configuramos el listener de clic para la imagen
        imageView.setOnClickListener {
            // Mostramos un Toast con el mensaje personalizado
            Toast.makeText(
                this,
                "¡Has hecho clic en la imagen!",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Configuramos el botón para navegar al reproductor de música
        val btnMusicPlayer = findViewById<Button>(R.id.btnMusicPlayer)
        btnMusicPlayer.setOnClickListener {
            // Creamos un Intent para abrir la actividad del reproductor
            val intent = Intent(this, MusicPlayerActivity::class.java)
            startActivity(intent)
        }
    }
}