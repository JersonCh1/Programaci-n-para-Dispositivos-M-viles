package com.example.practica4_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    // Clase Usuario definida internamente
    data class Usuario(
        val nombre: String,
        val edad: String,
        val ciudad: String,
        val correo: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: ""
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(nombre)
            parcel.writeString(edad)
            parcel.writeString(ciudad)
            parcel.writeString(correo)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Usuario> {
            override fun createFromParcel(parcel: Parcel): Usuario {
                return Usuario(parcel)
            }

            override fun newArray(size: Int): Array<Usuario?> {
                return arrayOfNulls(size)
            }
        }
    }

    // Constantes para guardar estado
    companion object {
        private const val KEY_NOMBRE = "nombre"
        private const val KEY_EDAD = "edad"
        private const val KEY_CIUDAD = "ciudad"
        private const val KEY_CORREO = "correo"
    }

    // Registro para el resultado de la actividad ResumenActivity
    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // El usuario confirmó el perfil
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
            // Podríamos limpiar los campos aquí si quisiéramos
        } else if (result.resultCode == Activity.RESULT_CANCELED) {
            // El usuario decidió volver a editar, no hacemos nada especial
            // ya que los datos siguen en los campos de texto
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Inicialización de vistas
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        // Restaurar estado si existe
        savedInstanceState?.let {
            etNombre.setText(it.getString(KEY_NOMBRE, ""))
            etEdad.setText(it.getString(KEY_EDAD, ""))
            etCiudad.setText(it.getString(KEY_CIUDAD, ""))
            etCorreo.setText(it.getString(KEY_CORREO, ""))
        }

        // Configurar el botón continuar
        btnContinuar.setOnClickListener {
            val usuario = Usuario(
                nombre = etNombre.text.toString(),
                edad = etEdad.text.toString(),
                ciudad = etCiudad.text.toString(),
                correo = etCorreo.text.toString()
            )

            // Crear el intent y agregar el objeto Usuario como extra
            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)

            // Iniciar la actividad esperando un resultado
            resumenLauncher.launch(intent)
        }
    }

    // Guardar el estado si la actividad se destruye (por ejemplo, al rotar la pantalla)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOMBRE, etNombre.text.toString())
        outState.putString(KEY_EDAD, etEdad.text.toString())
        outState.putString(KEY_CIUDAD, etCiudad.text.toString())
        outState.putString(KEY_CORREO, etCorreo.text.toString())
    }
}