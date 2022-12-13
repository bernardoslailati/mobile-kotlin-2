package aula_7

import aula_7.ResultadoBuscaUsuario.*
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

fun buscaUsuario(): ResultadoBuscaUsuario {
    val usuarioAleatorio = Usuario(nomeUsuario = "Bernardo", senha = "1234")

    return when(Random.nextInt(0, 3)) {
        0 -> Sucesso(usuarioBuscado = usuarioAleatorio, mensagem = "Sucesso ao buscar usuário!")
        1 -> Carregando
        2 -> Falha(erro = "Falha ao buscar usuário.")
        else -> Carregando
    }
}

fun main() {

    repeat(6) {
        when(val resposta = buscaUsuario()) {
            is Sucesso -> println("${resposta.mensagem} O usuário buscado foi ${resposta.usuarioBuscado}.")
            is Carregando -> {
                    println("Carregando...")
                    resposta.update()
                }
            is Falha -> println(resposta.erro)
        }
    }

}