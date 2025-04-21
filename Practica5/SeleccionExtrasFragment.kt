/**
 * Configurador de pedido de comida - Fragment de selección de extras
 * Permite al usuario seleccionar extras para su comida mediante CheckBoxes
 * Recibe el tipo de comida seleccionada del fragment anterior
 * Autor: Jerson Ernesto Chura Pacci
 * Fecha creación: 21/04/2025
 * Fecha última modificación: 21/04/2025
 */
package com.example.configuradorcomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class SeleccionExtrasFragment : Fragment() {

    private lateinit var comidaSeleccionada: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seleccion_extras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recuperar los datos pasados desde el fragmento anterior
        comidaSeleccionada = arguments?.getString("comida") ?: ""

        val tvComidaSeleccionada = view.findViewById<TextView>(R.id.tvComidaSeleccionada)
        tvComidaSeleccionada.text = "Comida seleccionada: $comidaSeleccionada"

        val cbBebida = view.findViewById<CheckBox>(R.id.cbBebida)
        val cbPapas = view.findViewById<CheckBox>(R.id.cbPapas)
        val cbPostre = view.findViewById<CheckBox>(R.id.cbPostre)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguiente)

        btnSiguiente.setOnClickListener {
            // Crear una lista de extras seleccionados
            val extras = mutableListOf<String>()
            if (cbBebida.isChecked) extras.add("Bebida")
            if (cbPapas.isChecked) extras.add("Papas fritas")
            if (cbPostre.isChecked) extras.add("Postre")

            // Crear un Bundle con toda la información del pedido
            val bundle = Bundle().apply {
                putString("comida", comidaSeleccionada)
                putStringArray("extras", extras.toTypedArray())
            }

            // Navegar al siguiente fragmento pasando los datos
            findNavController().navigate(
                R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment,
                bundle
            )
        }
    }
}