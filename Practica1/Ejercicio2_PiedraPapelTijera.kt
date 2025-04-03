/*
 * Descripción: Juego de Piedra, Papel o Tijera contra la computadora
 * Autor: Jerson Ernesto Chura Paaci
 * Fecha creación: 27/03/2025
 * Fecha última modificación: 27/03/2025
 */

import kotlin.random.Random

// Función para obtener la elección aleatoria de la computadora
fun obtenerEleccionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    val indice = Random.nextInt(opciones.size)
    return opciones[indice]
}

// Función para obtener la elección del usuario
fun obtenerEleccionUsuario(): String {
    while (true) {
        println("\nElige una opción:")
        println("1. Piedra")
        println("2. Papel")
        println("3. Tijera")
        print("Tu elección (1-3): ")

        when (readLine()?.trim()) {
            "1" -> return "piedra"
            "2" -> return "papel"
            "3" -> return "tijera"
            else -> println("Opción inválida. Intenta de nuevo.")
        }
    }
}

// Función para determinar el resultado del juego
fun determinarGanador(eleccionUsuario: String, eleccionComputadora: String): String {
    if (eleccionUsuario == eleccionComputadora) {
        return "¡Empate!"
    }

    return when {
        (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ||
                (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ||
                (eleccionUsuario == "tijera" && eleccionComputadora == "papel") -> "¡Ganaste!"
        else -> "¡Perdiste!"
    }
}

// Función principal del juego
fun jugarPiedraPapelTijera() {
    println("=== JUEGO DE PIEDRA, PAPEL O TIJERA ===")

    // Obtener elecciones
    val eleccionUsuario = obtenerEleccionUsuario()
    val eleccionComputadora = obtenerEleccionComputadora()

    // Mostrar elecciones
    println("\nTu elección: ${eleccionUsuario.capitalize()}")
    println("Elección de la computadora: ${eleccionComputadora.capitalize()}")

    // Determinar y mostrar resultado
    val resultado = determinarGanador(eleccionUsuario, eleccionComputadora)
    println("\nResultado: $resultado")
}

// Función principal
fun main() {
    jugarPiedraPapelTijera()
}