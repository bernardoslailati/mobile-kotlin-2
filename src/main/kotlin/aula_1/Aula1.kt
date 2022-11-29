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

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

    init {
        // (executado em primeiro)
        nome = nome.uppercase(Locale.getDefault())
        sobrenome = sobrenome.uppercase(Locale.getDefault())
    }

    constructor(nome: String, sobrenome: String, cpf: String) : this(
        -1,
        nome = nome,
        sobrenome = sobrenome,
        cpf = cpf,
        "Desconhecido",
        0.0
    ) {
        // (executado em segundo)
        this.nome = nome.lowercase(Locale.getDefault())
        this.sobrenome = sobrenome.lowercase(Locale.getDefault())
    }

    fun redefinirCargo(novoCargo: String, novoSalario: Double) {
        this.cargo = novoCargo
        this.salario = novoSalario * when (novoCargo) {
            "Gerente" -> 1.2
            "Vendedor" -> 1.1
            "Diretor" -> 1.5
            else -> 1.0
        }
    }

    fun buscaTextoSalarioMonetario(): String = currencyFormatter.format(salario)

    override fun toString(): String =
         """
            Nome: $nome
            Sobrenome: $sobrenome
            CPF: $cpf
            Cargo: $cargo
            Salário: ${currencyFormatter.format(salario)}
        """.trimIndent()

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
        id = 0,
        nome = "João",
        sobrenome = "Silva",
        cpf = "123456789",
        cargo = "Zelador",
        salario = 1_000.0
    )

    val joseVendedor = Funcionario(
        id = 1,
        nome = "José",
        sobrenome = "Silva",
        cpf = "123456789",
        cargo = "Vendedor",
        salario = 1_300.0
    )

    val mariaVendedora = Funcionario(
        nome = "Maria",
        sobrenome = "Ferreira",
        cpf = "01293012931"
    )

    joaoZelador.redefinirCargo("Gerente", 10_000.0)
    println("Novo salário de João [${joaoZelador.cargo}]: ${joaoZelador.buscaTextoSalarioMonetario()}")

    println()

    // Possuem o mesmo cpf
    println(joaoZelador.hashCode())
    println(joseVendedor.hashCode())

    println()

    // toString()
    println(mariaVendedora.toString())

}
