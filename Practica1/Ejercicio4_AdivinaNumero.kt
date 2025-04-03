/*
 * Descripción: Juego para adivinar un número aleatorio entre 1 y 30
 * Autor: Jerson Ernesto Chura Paaci
 * Fecha creación: 27/03/2025
 * Fecha última modificación: 27/03/2025
 */

import kotlin.random.Random

// Función para generar un número aleatorio entre 1 y 30
fun generarNumeroAleatorio(): Int {
    return Random.nextInt(1, 31)
}

// Función para obtener la suposición del usuario
fun obtenerSuposicion(): Int {
    while (true) {
        print("Ingresa tu suposición (1-30): ")
        val input = readLine()

        try {
            val numero = input?.toInt() ?: 0

            if (numero in 1..30) {
                return numero
            } else {
                println("Error: Debes ingresar un número entre 1 y 30.")
            }

        } catch (e: NumberFormatException) {
            println("Error: Debes ingresar un número válido.")
        }
    }
}

// Función para dar una pista al usuario
fun darPista(numeroAdivinar: Int, suposicion: Int) {
    if (suposicion < numeroAdivinar) {
        println("Pista: El número a adivinar es MAYOR que $suposicion")
    } else {
        println("Pista: El número a adivinar es MENOR que $suposicion")
    }
}

// Función principal del juego
fun jugarAdivinaNumero() {
    println("=== JUEGO ADIVINA EL NÚMERO ===")
    println("Estoy pensando en un número entre 1 y 30.")
    println("Tienes 5 intentos para adivinarlo.")

    val numeroAdivinar = generarNumeroAleatorio()
    val maxIntentos = 5
    var intentosRestantes = maxIntentos

    while (intentosRestantes > 0) {
        println("\nIntentos restantes: $intentosRestantes")
        val suposicion = obtenerSuposicion()

        if (suposicion == numeroAdivinar) {
            println("\n¡Felicidades! Has adivinado el número $numeroAdivinar.")
            println("¡Has ganado el juego!")
            return
        } else {
            darPista(numeroAdivinar, suposicion)
            intentosRestantes--
        }
    }

    println("\nGAME OVER. Se te acabaron los intentos.")
    println("El número que debías adivinar era: $numeroAdivinar")
}

// Función principal
fun main() {
    jugarAdivinaNumero()
}