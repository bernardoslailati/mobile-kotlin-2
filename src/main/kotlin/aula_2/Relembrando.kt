package aula_2

// Relembrando os conceitos vistos na aula 01...
//
// Enunciado: Desenvolva um sistema que possibilite o usuário criar uma EMPRESA (nome, cnpj, segmento, ...)
// e inserir, modificar, remover e mostrar FUNCIONÁRIOS (id, nome, sobrenome, cargo, salário, ...).
class Funcionario(val nome: String, val sobrenome: String, var cargo: String, var salario: Double) {

    override fun toString(): String {
        return """
            Funcionario(nome=$nome, sobrenome=$sobrenome, cargo=$cargo, salario=$salario)
        """.trimIndent()
    }

}

class Empresa(
    var nome: String,
    var cnpj: String,
    val segmento: String,
    private val listaFuncionarios: MutableList<Funcionario> = mutableListOf()
) {

    init {
        if (cnpj.length != 11)
            println("!!!Alerta!!!\nO valor do cnpj é inválido! Informe novamente.")

        nome = nome.uppercase()
    }

    fun inserirFuncionario(funcionario: Funcionario) {
        listaFuncionarios.add(funcionario)
    }

    fun mostrarFuncionarios() {
        println("Mostrar funcionarios = ${listaFuncionarios.toList()}")
    }

    fun removerFuncionario(nome: String, sobrenome: String) {
        val retornoDaBusca: Funcionario? = buscaFuncionarioNaLista(nome, sobrenome)
        val retornoDaRemocao: Boolean = listaFuncionarios.remove(retornoDaBusca)

        if (retornoDaRemocao)
            println("Funcionário removido com sucesso!")
        else
            println("Funcionário não se encontrava na lista.")
    }

    fun modificarFuncionario(nome: String, sobrenome: String, novoCargo: String, novoSalario: Double) {
        val funcionarioASerModificado: Funcionario? = buscaFuncionarioNaLista(nome, sobrenome)

        funcionarioASerModificado?.apply {
            this.cargo = novoCargo
            this.salario = novoSalario
        }
    }

    private fun buscaFuncionarioNaLista(nome: String, sobrenome: String): Funcionario? =
        listaFuncionarios.find { it.nome == nome && it.sobrenome == sobrenome }

}

fun main() {

    val santander = Empresa(segmento = "Banco", cnpj = "829371983719", nome = "Santander")

    val joaoDaSilva = Funcionario(nome = "João", sobrenome = "da Silva", cargo = "Gerente", salario = 6_000.0)

    santander.inserirFuncionario(joaoDaSilva)

    santander.mostrarFuncionarios()

//    santander.removerFuncionario(nome = "João", sobrenome = "da Silva")

    santander.mostrarFuncionarios()

    santander.modificarFuncionario(
        nome = "João",
        sobrenome = "da Silva",
        novoCargo = "Diretor de Vendas",
        novoSalario = 8_000.0
    )

    santander.mostrarFuncionarios()

}