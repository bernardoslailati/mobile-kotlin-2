package aula_5

import java.text.NumberFormat
import java.util.*

class ContaBancaria {

    private var saldo: Double = 0.0

    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double) {
        if (valor > saldo) {
            println("Valor em saldo menor que o valor a ser sacado. (Saldo = ${saldo.formataMonetario()})")
            return
        }
        saldo -= valor
    }

    fun buscaSaldo(): Double {
        return saldo
    }

}

fun Double.formataMonetario(): String {
    return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(this)
}

fun main() {

    val minhaContaBancaria = ContaBancaria()

    with(minhaContaBancaria) {
        println("O meu saldo é ${buscaSaldo().formataMonetario()}")
        depositar(100.0)
        sacar(15.0)
        println("O meu saldo é ${buscaSaldo().formataMonetario()}")
        sacar(100.0)
    }

}