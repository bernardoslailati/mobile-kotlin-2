package aula_5

import aula_5.Cargo.VENDEDOR

data class Empresa(val nome: String, val listaFuncionarios: MutableList<Funcionario> = mutableListOf()) {

    fun adicionaFuncionario(novoFuncionario: Funcionario) {
        listaFuncionarios.add(novoFuncionario)
    }

}

data class Funcionario(val nome: String, val sobrenome: String, val cpf: String, val telefone: String, val cargo: Cargo)

enum class Cargo(val salario: Double) {
    DESCONHECIDO(salario = 0.0),
    VENDEDOR(salario = 2_000.0),
    GERENTE(salario = 6_000.0),
    DIRETOR(salario = 10_000.0)
}

data class FormularioFuncionario(
    val nome: String, val sobrenome: String, val cpf: String, val telefone: String, val cargo: Cargo
)

private fun FormularioFuncionario.validaFormulario(): Funcionario? {
    // se todos os campos estiverem VÁLIDOS, retorna uma instância de funcionário
    // se pelo menos um campo estiver INVÁLIDO, retorna null
    //

    // 12345678901
    // cpf válido! funcionario => "123.456.789-01"

    fun formataCpf(): String {
        val padraoEsperado: Regex = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})".toRegex()
        val padraoFormatado = "$1.$2.$3-$4"

        return this.cpf.replace(padraoEsperado, padraoFormatado)
    }

    fun formataTelefoneComDDD(): String {
        val padraoEsperado: Regex = "([0-9]{2})([0-9]{4,5})([0-9]{4})".toRegex()
        val padraoFormatado = "($1) $2-$3"

        return this.telefone.replace(padraoEsperado, padraoFormatado)
    }

    return Funcionario(
        nome = this.nome.ifBlank { return null },
        sobrenome = this.sobrenome.ifBlank {
            println("O sobrenome está inválido.")
            return null },
        cpf = if (this.cpf != formataCpf()) formataCpf() else { return null },
        telefone = if (this.telefone != formataTelefoneComDDD()) formataTelefoneComDDD() else { return null },
        cargo = if (this.cargo.ordinal != 0) this.cargo else { return null },
    )
}


fun main() {

    val empresa = Empresa(nome = "Santander")

    // solictar o preenchimento do formulario por um usuario
    // nome, sobrenome, ...
    val formularioFuncionario = FormularioFuncionario(
        nome = "João",
        sobrenome = "Silva",
        cpf = "12345678901",
        telefone = "3733412235",
        cargo = VENDEDOR,
    )

    val funcionarioValidado: Funcionario? = formularioFuncionario.validaFormulario()

    if (funcionarioValidado != null) {
        empresa.adicionaFuncionario(funcionarioValidado)
        println(empresa)
    }
    else
        println("(!) Um ou mais campos do formulário foram inseridos de forma inválida.")

}

