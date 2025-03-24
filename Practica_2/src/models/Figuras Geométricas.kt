package models

// Descripción: Implementación de una jerarquía de clases para calcular área y perímetro de figuras geométricas
// Autor: Jerson Ernesto Chura Pacci
// Fecha creación: 24/03/2025
// Fecha última modificación: 24/03/2025

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Rectangulo(private val ancho: Double, private val alto: Double) : Shape() {
    override fun calcularArea() = ancho * alto
    override fun calcularPerimetro() = 2 * (ancho + alto)
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    val rectangulo = Rectangulo(4.0, 6.0)
    val circulo = Circulo(3.0)

    cuadrado.imprimirResultados()
    rectangulo.imprimirResultados()
    circulo.imprimirResultados()
}
