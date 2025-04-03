/*
 * Descripción: Programa que calcula el nivel de rendimiento y bonificación de un empleado
 * Autor: Jerson Ernesto Chura Paaci
 * Fecha creación: 27/03/2025
 * Fecha última modificación: 27/03/2025
 */

// Función que determina el nivel de rendimiento según la puntuación
fun determinarNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

// Función que calcula la cantidad de dinero a recibir
fun calcularBonificacion(salario: Double, puntuacion: Int): Double {
    return salario * (puntuacion / 10.0)
}

// Función principal que interactúa con el usuario
fun evaluarEmpleado() {
    println("=== SISTEMA DE EVALUACIÓN DE EMPLEADOS ===")

    // Solicitar datos al usuario
    print("Ingrese el salario mensual del empleado: $")
    val salario = readLine()?.toDoubleOrNull()

    if (salario == null || salario <= 0) {
        println("Error: Debe ingresar un salario válido (número positivo)")
        return
    }

    print("Ingrese la puntuación del empleado (0-10): ")
    val puntuacion = readLine()?.toIntOrNull()

    if (puntuacion == null || puntuacion < 0 || puntuacion > 10) {
        println("Error: La puntuación debe ser un número entre 0 y 10")
        return
    }

    // Calcular resultados
    val nivel = determinarNivelRendimiento(puntuacion)
    val bonificacion = calcularBonificacion(salario, puntuacion)

    // Mostrar resultados
    println("\n=== RESULTADOS ===")
    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $${String.format("%.2f", bonificacion)}")
}

// Función principal
fun main() {
    evaluarEmpleado()
}