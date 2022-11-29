package aula_1

import java.text.NumberFormat
import java.util.*

class Funcionario(
    val id: Int,
    var nome: String,
    var sobrenome: String,
    val cpf: String,
    var cargo: String,
    var salario: Double
) {

    init {
        // Bloco inicial a ser rodado...
        // (executado em primeiro)
        nome = nome.uppercase(Locale.getDefault())
        sobrenome = sobrenome.uppercase(Locale.getDefault())
    }

    constructor(nome: String, sobrenome: String, cpf: String) : this(0, nome = nome, sobrenome = sobrenome, cpf = cpf, "Desconhecido", 0.0) {
        // (executado em segundo)
        this.nome = nome.lowercase(Locale.getDefault())
        this.sobrenome = sobrenome.lowercase(Locale.getDefault())
    }

    fun redefinirCargo(novoCargo: String, salario: Double) {
        this.cargo = novoCargo
        this.salario = salario * when(novoCargo) {
            "Gerente" -> 1.2
            "Vendedor" -> 1.1
            "Diretor" -> 1.5
            else -> 1.0
        }
    }

    override fun toString(): String {
        val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

        return """
            Nome: $nome
            Sobrenome: $sobrenome
            CPF: $cpf
            Cargo: $cargo
            Salário: ${currencyFormatter.format(salario)}
        """.trimIndent()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Funcionario

        if (cpf != other.cpf) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + cpf.hashCode()
        result = 31 * result + cargo.hashCode()
        result = 31 * result + salario.hashCode()
        return result
    }
}

fun main() {

    val joaoZelador = Funcionario(
        0,
        "Joao",
        "Silva",
        "123456789",
        "Zelador",
        1_000.0
    )

    val joseVendedor = Funcionario(
        1,
        "José",
        "Silva",
        "123456789",
        "Vendedor",
        1_300.0
    )

    val mariaVendedora = Funcionario(
        "Maria",
        "Ferreira",
        "01293012931"
    )

    // Possuem o mesmo cpf
    joaoZelador.redefinirCargo("Gerente", 10_000.0)

    // Possuem o mesmo cpf
    println(joaoZelador.hashCode())
    println(joseVendedor.hashCode())

    // toString()
    println(mariaVendedora.toString())

}
