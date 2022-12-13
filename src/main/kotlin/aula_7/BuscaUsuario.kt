package aula_7

import aula_7.ResultadoBuscaUsuario.*
import kotlin.random.Random

data class Usuario(val nomeUsuario: String, val senha: String)

sealed class ResultadoBuscaUsuario {
    data class Sucesso(val usuarioBuscado: Usuario, val mensagem: String) : ResultadoBuscaUsuario()
    object Carregando : ResultadoBuscaUsuario()
    data class Falha(val erro: String) : ResultadoBuscaUsuario()
}

fun buscaUsuario(): ResultadoBuscaUsuario {
    val usuarioAleatorio = Usuario(nomeUsuario = "Bernardo", senha = "1234")

    return when(Random.nextInt(0, 3)) {
        0 -> Sucesso(usuarioBuscado = usuarioAleatorio, mensagem = "Sucesso ao buscar usuário!")
        1 -> Carregando
        2 -> Falha(erro = "Falha ao buscar usuário")
        else -> Carregando
    }
}

fun main() {

    repeat(6) {
        buscaUsuario()
    }

}