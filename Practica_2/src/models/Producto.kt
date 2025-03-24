// Descripción: Clase que representa una cuenta bancaria con saldo y límite de retiro
// Autor: Jerson Ernesto Chura Pacci
// Fecha creación: 24/03/2025
// Fecha última modificación: 24/03/2025

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    fun getSaldo(): Double = saldo

    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("Error: No puedes tener saldo negativo.")
        }
    }

    fun retirar(monto: Double) {
        if (monto > limiteRetiro) {
            println("Error: No puedes retirar más de $limiteRetiro")
        } else if (monto > saldo) {
            println("Error: Saldo insuficiente.")
        } else {
            saldo -= monto
            println("Retiro exitoso. Nuevo saldo: $saldo")
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    cuenta.retirar(200.0)
    cuenta.retirar(600.0)
}
