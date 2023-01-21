package desafios.aquario.menu

import java.lang.NumberFormatException

class Menu {
    private var executarSistema = true
    fun emExecucao(): Boolean = executarSistema
    fun fecharSistema() {
        executarSistema = false
    }
    fun resetarSistema() {
        executarSistema = true
    }
}

const val OPCAO_INVALIDA = -1

fun readlnInt() = try {
    readln().toInt()
} catch (e: NumberFormatException) {
    println("Opção inválida! Tente novamente...")
    OPCAO_INVALIDA
}




