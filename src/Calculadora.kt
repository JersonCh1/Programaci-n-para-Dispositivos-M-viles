/**
 * Calculadora Básica
 * Autor: Jerson Ernesto Chura Pacci
 * Fecha de creación: 13/03/2025
 * Última modificación: 13/03/2025
 *
 * Descripción: Realiza operaciones matemáticas básicas mediante un menú interactivo.
 */

fun main() {
    while (true) {
        println("\n==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Elige una opción: ")

        when (val opcion = readln().toIntOrNull()) {
            1, 2, 3, 4 -> {
                print("Ingresa el primer número: ")
                val num1 = readln().toDouble()
                print("Ingresa el segundo número: ")
                val num2 = readln().toDouble()

                val resultado = when (opcion) {
                    1 -> num1 + num2
                    2 -> num1 - num2
                    3 -> num1 * num2
                    4 -> if (num2 != 0.0) num1 / num2 else "Error: División por cero"
                    else -> "Opción inválida"
                }

                println("Resultado: $resultado")
            }
            5 -> {
                println("Saliendo...")
                break
            }
            else -> println("Opción inválida. Intenta de nuevo.")
        }
    }
}
