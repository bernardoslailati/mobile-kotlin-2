package desafios.carteiras_bancarias.modelos.carteiras

import java.text.NumberFormat
import java.util.*

open class Carteira(
    protected var saldo: Double = 0.0,
    protected val extrato: MutableList<Pair<String, Double>> = mutableListOf(),
) {
    companion object {
        private val formatadorMonetario: NumberFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
        fun Double.formataMonetario(): String = formatadorMonetario.format(this)
    }

    protected var saldoCofre: Double = 0.0
    protected var saldoInvestimentos: Double = 0.0

    fun consultaSaldo() {
        println(
            "Saldo total: ${saldo.formataMonetario()}"
        )
    }

    fun consultaSaldoCofre() {
        println(
            "Saldo em cofre: ${saldoCofre.formataMonetario()}"
        )
    }

    fun consultaSaldoInvestimentos() {
        println(
            "Saldo em investimentos: ${saldoInvestimentos.formataMonetario()}"
        )
    }

    fun consultaExtrato() {
        println(
            extrato.joinToString(
                prefix = "******** Extrato completo ********\n",
                postfix = "\n********************************",
                separator = "\n"
            ) { (operacao, valor) ->
                "${operacao}: ${valor.formataMonetario()}"
            }
        )
    }

    protected fun saldoSuficiente(valor: Double): Boolean {
        val eSuficiente = saldo - valor >= 0.0

        if (!eSuficiente)
            println("Saldo insuficiente (${saldo.formataMonetario()}).")

        return eSuficiente
    }
}

class CarteiraFisica : Carteira(), OperacoesFisicas {

    override fun deposito(valor: Double) {
        saldo += valor
        extrato.add(Operacoes.DEPOSITO.descricao to valor)
        println("Sucesso ao depositar valor de ${valor.formataMonetario()}!")
    }

    override fun saque(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.SAQUE.descricao to -valor)
            println("Sucesso ao sacar valor de ${valor.formataMonetario()}!")
        }
    }

    override fun pagarBoleto(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.PAGAR_BOLETO.descricao to -valor)
            println("Sucesso ao pagar boleto no valor de ${valor.formataMonetario()}!")
        }
    }

}

class CarteiraDigital : Carteira(), OperacoesDigitais {

    override fun transferenciaPix(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.TRANSFERENCIA_PIX.descricao to -valor)
            println("Sucesso ao transferir via PIX valor de ${valor.formataMonetario()}!")
        }
    }

    override fun investir(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            saldoInvestimentos += valor
            extrato.add(Operacoes.INVESTIMENTO.descricao to valor)
            println("Sucesso ao investir valor de ${valor.formataMonetario()}!")
        }
    }

    override fun guardar(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            saldoCofre += valor
            extrato.add(Operacoes.GUARDAR.descricao to valor)
            println("Sucesso ao guardar valor de ${valor.formataMonetario()}!")
        }
    }

    override fun receberTransferencia(valor: Double) {
        saldo += valor
        extrato.add(Operacoes.RECEBER_TRANSFERENCIA.descricao to valor)
        println("Sucesso ao receber transferência no valor de ${valor.formataMonetario()}!")
    }

    override fun pagarBoleto(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.PAGAR_BOLETO.descricao to -valor)
            println("Sucesso ao pagar boleto no valor de ${valor.formataMonetario()}!")
        }
    }

}

class CarteiraPremium : Carteira(), OperacoesFisicas, OperacoesDigitais {

    override fun transferenciaPix(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.TRANSFERENCIA_PIX.descricao to -valor)
            println("Sucesso ao transferir via PIX valor de ${valor.formataMonetario()}!")
        }
    }

    override fun investir(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            saldoInvestimentos += valor
            extrato.add(Operacoes.INVESTIMENTO.descricao to valor)
            println("Sucesso ao investir valor de ${valor.formataMonetario()}!")
        }
    }

    override fun guardar(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            saldoCofre += valor
            extrato.add(Operacoes.GUARDAR.descricao to valor)
            println("Sucesso ao guardar valor de ${valor.formataMonetario()}!")
        }
    }

    override fun receberTransferencia(valor: Double) {
        saldo += valor
        extrato.add(Operacoes.RECEBER_TRANSFERENCIA.descricao to valor)
        println("Sucesso ao receber transferência no valor de ${valor.formataMonetario()}!")
    }

    override fun deposito(valor: Double) {
        saldo += valor
        extrato.add(Operacoes.DEPOSITO.descricao to valor)
        println("Sucesso ao depositar valor de ${valor.formataMonetario()}!")
    }

    override fun saque(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.SAQUE.descricao to -valor)
            println("Sucesso ao sacar valor de ${valor.formataMonetario()}!")
        }
    }

    override fun pagarBoleto(valor: Double) {
        if (saldoSuficiente(valor)) {
            saldo -= valor
            extrato.add(Operacoes.PAGAR_BOLETO.descricao to -valor)
            println("Sucesso ao pagar boleto no valor de ${valor.formataMonetario()}!")
        }
    }

}