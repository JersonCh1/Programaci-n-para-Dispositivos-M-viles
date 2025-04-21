/**
 * Configurador de pedido de comida - Fragment de resumen del pedido
 * Muestra al usuario un resumen de su pedido (comida y extras seleccionados)
 * Permite confirmar el pedido o editarlo volviendo a la pantalla de selección de comida
 * Utiliza Fragment Result API para comunicarse con fragments anteriores
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
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

class ResumenPedidoFragment : Fragment() {

    private lateinit var comidaSeleccionada: String
    private lateinit var extrasSeleccionados: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resumen_pedido, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recuperar los datos pasados desde el fragmento anterior
        comidaSeleccionada = arguments?.getString("comida") ?: ""
        extrasSeleccionados = arguments?.getStringArray("extras") ?: emptyArray()

        // Mostrar los datos del pedido
        val tvComidaResumen = view.findViewById<TextView>(R.id.tvComidaResumen)
        val tvExtrasResumen = view.findViewById<TextView>(R.id.tvExtrasResumen)

        tvComidaResumen.text = "Comida: $comidaSeleccionada"

        val extrasTexto = if (extrasSeleccionados.isNotEmpty()) {
            extrasSeleccionados.joinToString(", ")
        } else {
            "Ninguno"
        }
        tvExtrasResumen.text = "Extras: $extrasTexto"

        // Configurar botones
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = view.findViewById<Button>(R.id.btnEditar)

        btnConfirmar.setOnClickListener {
            // Mostrar mensaje de confirmación
            Toast.makeText(
                requireContext(),
                "¡Pedido confirmado! Tu $comidaSeleccionada está en camino.",
                Toast.LENGTH_LONG
            ).show()

            // Volver al inicio
            findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
        }

        btnEditar.setOnClickListener {
            // Preparar los datos del pedido para enviarlos de regreso
            val result = bundleOf("comida" to comidaSeleccionada)

            // Configurar el resultado del fragmento para que lo reciba SeleccionComidaFragment
            setFragmentResult("datosPedido", result)

            // Volver a SeleccionComidaFragment usando popBackStack
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }
    }
}