/**
 * Evaluación de Empleados
 * Autor: Jerson Ernesto Chura Pacci
 * Fecha de creación: 13/03/2025
 * Última modificación: 13/03/2025
 *
 * Descripción: Calcula el nivel de rendimiento de un empleado según su puntuación y salario.
 */

fun calcularRendimiento(puntuacion: Int, salario: Double): Pair<String, Double> {
    val nivel = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }

    val dineroRecibido = if (puntuacion in 0..10) salario * (puntuacion / 10.0) else 0.0

    return Pair(nivel, dineroRecibido)
}

fun main() {
    print("Ingresa tu salario mensual: ")
    val salario = readln().toDouble()

    print("Ingresa tu puntuación (0-10): ")
    val puntuacion = readln().toInt()

    val (nivel, dinero) = calcularRendimiento(puntuacion, salario)

    println("Nivel de rendimiento: $nivel")
    println("Cantidad de dinero recibido: $$dinero")
}
