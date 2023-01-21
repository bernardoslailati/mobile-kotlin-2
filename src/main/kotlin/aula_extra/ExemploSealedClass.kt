package aula_extra

import aula_7.ResultadoBuscaUsuario.*
import aula_7.Usuario
import kotlin.random.Random

data class Usuario(val nomeUsuario: String, val senha: String)

sealed class ResultadoBuscaUsuario(val tipo: Int) {
    data class Sucesso(val usuarioBuscado: Usuario, val mensagem: String) : ResultadoBuscaUsuario(tipo = 1)
    object Carregando : ResultadoBuscaUsuario(tipo = 0) {
        fun update(): ResultadoBuscaUsuario {
            return Sucesso(usuarioBuscado = Usuario("", ""), mensagem = "Carregando foi atualizado!")
        }
    }
    data class Falha(val erro: String) : ResultadoBuscaUsuario(tipo = -1)

    fun buscaTipo() {
        println("Meu tipo é $tipo.")
    }
}

enum class Cor {
    AMARELO,
    VERMELHO,
    VERDE
}

fun main() {
    val resultadoBuscaUsuario = when(Random.nextInt(0, 3)) {
        0 -> Sucesso(
            usuarioBuscado = Usuario(nomeUsuario = "X", senha = "Y"),
            mensagem = "Sucesso ao buscar usuário!"
        )
        1 -> Carregando
        2 -> Falha(erro = "Falha ao buscar usuário.")
        else -> Carregando
    }

    when(resultadoBuscaUsuario) {
        is Sucesso -> println("O usuário buscado.")
        is Carregando -> {
            println("Carregando...")
        }
        is Falha -> println("Erro")
    }
}