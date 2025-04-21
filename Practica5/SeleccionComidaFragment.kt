/**
 * Configurador de pedido de comida - Fragment de selección de comida
 * Permite al usuario seleccionar un tipo de comida mediante RadioButtons
 * Recibe datos cuando se edita un pedido existente (mediante FragmentResultListener)
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
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class SeleccionComidaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seleccion_comida, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rgComidas = view.findViewById<RadioGroup>(R.id.rgComidas)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguiente)

        // Escuchar los resultados del fragmento de resumen (cuando se edita)
        setFragmentResultListener("datosPedido") { _, bundle ->
            val comidaSeleccionada = bundle.getString("comida", "")

            // Marca el RadioButton correspondiente según la comida seleccionada previamente
            when (comidaSeleccionada) {
                "Pizza" -> rgComidas.check(R.id.rbPizza)
                "Hamburguesa" -> rgComidas.check(R.id.rbHamburguesa)
                "Ensalada" -> rgComidas.check(R.id.rbEnsalada)
            }
        }

        btnSiguiente.setOnClickListener {
            // Obtener la comida seleccionada
            val selectedId = rgComidas.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedId)
            val comidaSeleccionada = radioButton.text.toString()

            // Crear un Bundle para pasar los datos
            val bundle = Bundle().apply {
                putString("comida", comidaSeleccionada)
            }

            // Navegar al siguiente fragmento pasando los datos
            findNavController().navigate(
                R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment,
                bundle
            )
        }
    }
}