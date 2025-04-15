/**
 * Clase Parcelable para transferir datos de usuario entre actividades
 * Autor: [Tu nombre]
 * Fecha creación: 15/04/2025
 * Última modificación: 15/04/2025
 */
package com.example.practica4_1

import android.os.Parcel
import android.os.Parcelable

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