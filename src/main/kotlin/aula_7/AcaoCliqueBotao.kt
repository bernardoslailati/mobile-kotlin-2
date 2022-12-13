package aula_7

import aula_7.Cor.*

interface AcaoCliqueBotao {
    fun clique()
    fun cliqueLongo()
    fun duploClique()
}

enum class Cor {
    VERDE, VERMELHO, CINZA
}


class Botao(val texto: String, private val cor: Cor, val acaoCliqueBotao: AcaoCliqueBotao? = null)

fun main() {

    val botaoConfirmar = Botao(texto = "Confirmar", cor = VERDE, acaoCliqueBotao = object : AcaoCliqueBotao {
        override fun clique() {
            println("Clique no botão confirmar!")
        }

        override fun cliqueLongo() {
            println("Clique longo no botão confirmar!")
        }

        override fun duploClique() {
            println("Clique duplo no botão confirmar!")
        }
    })

    val botaoResetar = Botao(texto = "Resetar", cor = VERMELHO, acaoCliqueBotao = object : AcaoCliqueBotao {
        override fun clique() {
            println("Clique no botão resetar!")
        }

        override fun cliqueLongo() {
            println("Clique longo no botão resetar!")
        }

        override fun duploClique() {
            println("Clique duplo no botão resetar!")
        }
    })

    val botaoNeutro = Botao(texto = "Neutro", cor = CINZA, acaoCliqueBotao = object : AcaoCliqueBotao {
        override fun clique() {
            println("Clique no botão neutro!")
        }

        override fun cliqueLongo() {
            println("Clique longo no botão neutro!")
        }

        override fun duploClique() {
            println("Clique duplo no botão neutro!")
        }
    })

    botaoNeutro.acaoCliqueBotao?.let { acaoClique ->
        acaoClique.clique()
        acaoClique.cliqueLongo()
        acaoClique.duploClique()
    }

    botaoNeutro.acaoCliqueBotao?.also { acaoClique ->
        println(acaoClique.hashCode())
        acaoClique.clique()
        acaoClique.cliqueLongo()
        acaoClique.duploClique()
    }

}