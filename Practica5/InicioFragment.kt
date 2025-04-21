/**
 * Configurador de pedido de comida - Fragment inicial
 * Muestra la pantalla de bienvenida con un botón para iniciar un nuevo pedido
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
import androidx.navigation.fragment.findNavController

class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnNuevoPedido).setOnClickListener {
            // Navegar a SeleccionComidaFragment
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }
    }
}