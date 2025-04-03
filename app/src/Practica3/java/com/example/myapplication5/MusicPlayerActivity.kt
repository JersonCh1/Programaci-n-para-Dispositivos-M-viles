/*
 * Descripción: Reproductor de música básico que reproduce, pausa y detiene archivos de audio
 * Autor: Tu nombre
 * Fecha creación: 27/03/2025
 * Última modificación: 27/03/2025
 */

package com.example.myapplication5 // Asegúrate que coincida con tu paquete

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MusicPlayerActivity : AppCompatActivity() {

    // Declaramos el MediaPlayer como variable de la clase
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var statusTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        // Referencias a los elementos de la UI
        val playButton = findViewById<Button>(R.id.playButton)
        val pauseButton = findViewById<Button>(R.id.pauseButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        statusTextView = findViewById(R.id.statusTextView)

        // Botón de reproducir
        playButton.setOnClickListener {
            // Si el MediaPlayer no está inicializado o está detenido, lo inicializamos
            if (mediaPlayer == null) {
                // Creamos un nuevo MediaPlayer y asignamos el archivo de audio
                mediaPlayer = MediaPlayer.create(this, R.raw.musica_ejemplo)

                // Configuramos un listener para cuando finalice la reproducción
                mediaPlayer?.setOnCompletionListener {
                    resetMediaPlayer()
                }
            }

            // Iniciamos la reproducción
            mediaPlayer?.start()
            statusTextView.text = "Estado: Reproduciendo"
        }

        // Botón de pausar
        pauseButton.setOnClickListener {
            // Si el MediaPlayer está reproduciendo, lo pausamos
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                statusTextView.text = "Estado: Pausado"
            }
        }

        // Botón de detener
        stopButton.setOnClickListener {
            resetMediaPlayer()
        }
    }

    private fun resetMediaPlayer() {
        // Detenemos y liberamos el MediaPlayer
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        statusTextView.text = "Estado: Detenido"
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberamos los recursos cuando se destruye la actividad
        mediaPlayer?.release()
        mediaPlayer = null
    }
}