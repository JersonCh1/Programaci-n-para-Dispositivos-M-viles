/*
 * Descripción: Calculadora básica con operaciones de suma, resta, multiplicación y división
 * Autor: Jerson Ernesto Chura Paaci
 * Fecha creación: 27/03/2025
 * Fecha última modificación: 27/03/2025
 */

// Función para mostrar el menú
fun mostrarMenu() {
    println("\n==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
    print("Elige una opción (1-5): ")
}

// Función para obtener un número válido del usuario
fun obtenerNumero(mensaje: String): Double {
    while (true) {
        print(mensaje)
        val input = readLine()

        try {
            return input?.toDouble() ?: throw NumberFormatException()
        } catch (e: NumberFormatException) {
            println("Error: Debes ingresar un número válido.")
        }
    }
}

// Función para realizar la operación seleccionada
fun realizarOperacion(opcion: Int) {
    if (opcion < 1 || opcion > 4) {
        return
    }

    val num1 = obtenerNumero("Ingresa el primer número: ")
    val num2 = obtenerNumero("Ingresa el segundo número: ")

    val resultado = when (opcion) {
        1 -> num1 + num2
        2 -> num1 - num2
        3 -> num1 * num2
        4 -> {
            if (num2 == 0.0) {
                println("Error: No se puede dividir por cero.")
                return
            }
            num1 / num2
        }
        else -> 0.0 // No debería llegar aquí por la validación inicial
    }

    val operacion = when (opcion) {
        1 -> "Suma"
        2 -> "Resta"
        3 -> "Multiplicación"
        4 -> "División"
        else -> ""
    }

    println("\nResultado de la $operacion: $resultado")
}

// Función principal de la calculadora
fun ejecutarCalculadora() {
    println("=== CALCULADORA ELEMENTAL ===")

    var opcion: Int

    do {
        mostrarMenu()
        val input = readLine()

        try {
            opcion = input?.toInt() ?: 0

            if (opcion !in 1..5) {
                println("Error: Opción inválida. Introduce un número del 1 al 5.")
                continue
            }

            if (opcion != 5) {
                realizarOperacion(opcion)
            }

        } catch (e: NumberFormatException) {
            println("Error: Debes ingresar un número.")
            opcion = 0
        }

    } while (opcion != 5)

    println("\nGracias por usar la calculadora. ¡Hasta pronto!")
}

// Función principal
fun main() {
    ejecutarCalculadora()
}