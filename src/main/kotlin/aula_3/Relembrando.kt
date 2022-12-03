package aula_3

import aula_3.Dia.*
import aula_3.Materia.*

// Crie uma classe enumerada que represente diferentes tipos de aulas que um professor
// poderá dar e os dias que ele deverá lecioná-las.

enum class Dia(val nome: String, val abreviacao: String) {
    DOMINGO(nome = "Domingo", abreviacao = "dom"),
    SEGUNDA(nome = "Segunda", abreviacao = "seg"),
    TERCA(nome = "Terça", abreviacao = "ter"),
    QUARTA(nome = "Quarta", abreviacao = "qua"),
}

enum class Materia(val nome: String, val diasDeAula: List<Dia>) {
    PORTUGUES(nome = "Português", diasDeAula = listOf(SEGUNDA, QUARTA)),
    MATEMATICA(nome = "Matemática", diasDeAula = listOf(TERCA)),
    CIENCIA(nome = "Ciências", diasDeAula = listOf(TERCA)),
    GEOGRAFIA(nome = "Geografia", diasDeAula = listOf(SEGUNDA));

    override fun toString(): String {
        return """
            $nome nos dias ${
            diasDeAula.joinToString(
                separator = "|",
                prefix = "(",
                postfix = ")",
                transform = { dia -> dia.abreviacao }
            )
        }
        """.trimIndent()
    }

}

data class Professor(val id: Int, val nome: String, val sobrenome: String, val materias: List<Materia>) {

    override fun toString(): String {
        return """
            O professor $nome $sobrenome de número identificador #$id leciona as aulas ${materias.joinToString()}.
        """.trimIndent()
    }
}

fun main() {

    val professorDePortugues =
        Professor(
            id = 100,
            nome = "Roberto",
            sobrenome = "Cunha",
            materias = listOf(PORTUGUES, MATEMATICA, CIENCIA, GEOGRAFIA)
        )

    println(professorDePortugues)

}