package desafios.carteiras_bancarias.modelos

import desafios.carteiras_bancarias.modelos.clientes.ClienteDigital
import desafios.carteiras_bancarias.modelos.clientes.ClienteFisico
import desafios.carteiras_bancarias.modelos.clientes.ClientePremium

fun main() {

    val clienteDigital = ClienteDigital(
        nome = "Cliente",
        sobrenome = "Digital",
        cpf = "11111111111",
        senha = "111"
    )

    val clienteFisico = ClienteFisico(
        nome = "Cliente",
        sobrenome = "Físico",
        cpf = "222222222",
        senha = "222"
    )

    val clientePremium = ClientePremium(
        nome = "Cliente",
        sobrenome = "Premium",
        cpf = "333333333",
        senha = "333"
    )

    println("****** Cliente Físico ******")
    println()
    with(clienteFisico) {
        consultaSaldo()
        println()
        deposito(senhaInserida = "222", 1000.0)
        saque(senhaInserida = "111", 500.0)       // senha incorreta...
        saque(senhaInserida = "222", 500.0)
        pagarBoleto(senhaInserida = "222", 200.0)
        println()
        consultaExtrato()
        println()
        consultaSaldo()
    }

//    println("****** Cliente Digital ******")
//    with(clienteDigital) {
//        consultaSaldo()
//        println()
//        receberTransferencia(senhaInserida = "111", 400.0)
//        transferenciaPix(senhaInserida = "111", 150.0)
//        investir(senhaInserida = "111", 50.0)
//        guardar(senhaInserida = "123", 50.0)          // senha incorreta...
//        guardar(senhaInserida = "111", 50.0)
//        pagarBoleto(senhaInserida = "111", 500.0)       // saldo insuficiente...
//        pagarBoleto(senhaInserida = "111", 25.80)
//        println()
//        consultaExtrato()
//        println()
//        consultaSaldo()
//        println()
//        consultaSaldoInvestimentos()
//        println()
//        consultaSaldoCofre()
//    }

//    println("****** Cliente Premium ******")
//    with(clientePremium) {
//        consultaSaldo()
//        println()
//        receberTransferencia(senhaInserida = "333", 10_000.0)
//        transferenciaPix(senhaInserida = "333", 5_000.0)
//        investir(senhaInserida = "123", 500.0)              // senha incorreta...
//        investir(senhaInserida = "333", 500.0)
//        guardar(senhaInserida = "333", 1_000.0)
//        deposito(senhaInserida = "333", 1_000.0)
//        saque(senhaInserida = "333", 500.0)
//        pagarBoleto(senhaInserida = "333", 10_000.0)    // saldo insuficiente...
//        pagarBoleto(senhaInserida = "333", 1000.0)
//        println()
//        consultaExtrato()
//        println()
//        consultaSaldo()
//        println()
//        consultaSaldoInvestimentos()
//        println()
//        consultaSaldoCofre()
//    }

}




