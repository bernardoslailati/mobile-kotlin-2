package desafios.carteiras_bancarias.modelos.clientes

import desafios.carteiras_bancarias.modelos.carteiras.CarteiraDigital
import desafios.carteiras_bancarias.modelos.carteiras.CarteiraFisica
import desafios.carteiras_bancarias.modelos.carteiras.CarteiraPremium

open class Cliente(
    private val numeroConta: String = String.format("%04d", (1..9999).random()),
    val nome: String,
    val sobrenome: String,
    private val cpf: String,
    private val senha: String
) {

    private val nomeCompleto: String
        get() = "$nome $sobrenome"

    fun descricaoConta() {
        println("Número da Conta: #$numeroConta | Cliente: $nomeCompleto | CPF: $cpf")
    }

    fun senhaValida(senhaInserida: String): Boolean {
        val eValida = senha == senhaInserida

        if (!eValida) println("Senha inválida. Tente novamente.")

        return eValida
    }

}

class ClienteFisico(
    nome: String,
    sobrenome: String,
    cpf: String,
    senha: String
) : Cliente(nome = nome, sobrenome = sobrenome, cpf = cpf, senha = senha) {

    private val carteira: CarteiraFisica = CarteiraFisica()

    fun deposito(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.deposito(valor)
    }

    fun saque(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.saque(valor)
    }

    fun pagarBoleto(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.pagarBoleto(valor)
    }

    fun consultaExtrato() {
        descricaoConta()
        carteira.consultaExtrato()
    }

    fun consultaSaldo() {
        descricaoConta()
        carteira.consultaSaldo()
    }

}

class ClienteDigital(
    nome: String,
    sobrenome: String,
    cpf: String,
    senha: String
) : Cliente(nome = nome, sobrenome = sobrenome, cpf = cpf, senha = senha) {

    private val carteira: CarteiraDigital = CarteiraDigital()

    fun transferenciaPix(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.transferenciaPix(valor)
    }

    fun investir(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.investir(valor)
    }

    fun receberTransferencia(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.receberTransferencia(valor)
    }

    fun guardar(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.guardar(valor)
    }

    fun pagarBoleto(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.pagarBoleto(valor)
    }

    fun consultaExtrato() {
        descricaoConta()
        carteira.consultaExtrato()
    }

    fun consultaSaldo() {
        descricaoConta()
        carteira.consultaSaldo()
    }

    fun consultaSaldoInvestimentos() {
        descricaoConta()
        carteira.consultaSaldoInvestimentos()
    }

    fun consultaSaldoCofre() {
        descricaoConta()
        carteira.consultaSaldoCofre()
    }

}

class ClientePremium(
    nome: String,
    sobrenome: String,
    cpf: String,
    senha: String
) : Cliente(nome = nome, sobrenome = sobrenome, cpf = cpf, senha = senha) {

    private val carteira: CarteiraPremium = CarteiraPremium()

    fun deposito(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.deposito(valor)
    }

    fun saque(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.saque(valor)
    }

    fun transferenciaPix(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.transferenciaPix(valor)
    }

    fun receberTransferencia(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.receberTransferencia(valor)
    }

    fun investir(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.investir(valor)
    }

    fun guardar(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.guardar(valor)
    }

    fun pagarBoleto(senhaInserida: String, valor: Double) {
        if (senhaValida(senhaInserida))
            carteira.pagarBoleto(valor)
    }

    fun consultaExtrato() {
        descricaoConta()
        carteira.consultaExtrato()
    }

    fun consultaSaldo() {
        descricaoConta()
        carteira.consultaSaldo()
    }

    fun consultaSaldoInvestimentos() {
        descricaoConta()
        carteira.consultaSaldoInvestimentos()
    }

    fun consultaSaldoCofre() {
        descricaoConta()
        carteira.consultaSaldoCofre()
    }

}