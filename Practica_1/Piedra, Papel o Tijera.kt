import kotlin.random.Random

/**
 * Piedra, Papel o Tijera
 * Autor: Jerson Ernesto Chura Pacci
 * Fecha de creación: 13/03/2025
 * Última modificación: 13/03/2025
 *
 * Descripción: Simula el juego de piedra, papel o tijera contra la computadora.
 */

fun main() {
    val opciones = listOf("piedra", "papel", "tijera")
    val eleccionComputadora = opciones[Random.nextInt(3)]

    print("Elige (piedra, papel o tijera): ")
    val eleccionUsuario = readln().lowercase()

    if (eleccionUsuario !in opciones) {
        println("Opción no válida. Inténtalo de nuevo.")
        return
    }

    println("Computadora eligió: $eleccionComputadora")

    val resultado = when {
        eleccionUsuario == eleccionComputadora -> "¡Empate!"
        (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ||
                (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ||
                (eleccionUsuario == "tijera" && eleccionComputadora == "papel") -> "¡Ganaste!"
        else -> "¡Perdiste!"
    }

    println(resultado)
}
