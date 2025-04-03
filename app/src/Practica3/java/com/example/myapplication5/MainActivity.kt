/*
 * Descripción: Aplicación que muestra una imagen y muestra un Toast al hacer clic en ella
 * Autor: Tu nombre
 * Fecha: 27/03/2025
 */
package com.example.myapplication5  // Asegúrate que coincida con tu paquete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Código para imagen interactiva
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            Toast.makeText(this, "¡Has hecho clic en la imagen!", Toast.LENGTH_SHORT).show()
        }

        // Botón para ir al reproductor
        val btnMusicPlayer = findViewById<Button>(R.id.btnMusicPlayer)
        btnMusicPlayer.setOnClickListener {
            val intent = Intent(this, MusicPlayerActivity::class.java)
            startActivity(intent)
        }
    }
}