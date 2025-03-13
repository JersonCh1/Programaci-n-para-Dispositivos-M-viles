import kotlin.random.Random

/**
 * Adivina el Número
 * Autor: Jerson Ernesto Chura Pacci
 * Fecha de creación: 13/03/2025
 * Última modificación: 13/03/2025
 *
 * Descripción: Juego donde el usuario intenta adivinar un número aleatorio en 5 intentos.
 */

fun main() {
    val numeroSecreto = Random.nextInt(1, 31)
    var intentos = 5

    println("¡Bienvenido a Adivina el Número!")
    println("Tienes 5 intentos para adivinar un número entre 1 y 30.")

    while (intentos > 0) {
        print("Ingresa tu número: ")
        val numeroUsuario = readln().toIntOrNull()

        if (numeroUsuario == null || numeroUsuario !in 1..30) {
            println("Número inválido. Ingresa un número entre 1 y 30.")
            continue
        }

        when {
            numeroUsuario == numeroSecreto -> {
                println("🎉 ¡Felicidades! Adivinaste el número $numeroSecreto.")
                return
            }
            numeroUsuario > numeroSecreto -> println("El número es menor.")
            else -> println("El número es mayor.")
        }

        intentos--
        println("Intentos restantes: $intentos")
    }

    println("Game Over. El número era $numeroSecreto.")
}
