package desafios.aquario.menu

import desafios.aquario.menu.MenuCor.Companion.escolherCor
import desafios.aquario.menu.MenuTamanho.Companion.escolherTamanho
import desafios.aquario.modelos.Peixe

enum class MenuPeixe(val opcao: Int) {
    COR(1),
    TAMANHO(2),
    SAIR(0);

    companion object {
        private val menu = Menu()
        private const val INICIO = "Escolha o seu peixe:"

        private fun mostrarOpcoes() {
            println(INICIO)
            values().forEach { println("${it.opcao} - ${it.name}") }
        }

        private fun obterAcao(): Int {
            mostrarOpcoes()
            return readlnInt()
        }

        fun escolherPeixe(): Peixe? {
            var cor: String? = null
            var tamanho: String? = null

            menu.resetarSistema()
            var peixeEscolhido: Peixe? = null
            while (menu.emExecucao()) {
                println("Descrição do peixe escolhido => Cor: ${cor ?: "?"} | Tamanho: ${tamanho ?: "?"}")
                when (obterAcao()) {
                    COR.opcao -> {
                        cor = escolherCor()
                        println("Cor escolhida: $cor")
                    }

                    TAMANHO.opcao -> {
                        tamanho = escolherTamanho()
                        println("Tamanho escolhido: $tamanho")
                    }

                    SAIR.opcao -> menu.fecharSistema()
                    else -> println("Opção inválida. Tente novamente...")
                }

                if (peixeFoiEscolhidoCorretamente(cor, tamanho)) {
                    menu.fecharSistema()
                    peixeEscolhido = Peixe(cor!!, tamanho!!)
                }
            }

            return peixeEscolhido
        }
    }
}

private fun peixeFoiEscolhidoCorretamente(cor: String?, tamanho: String?) = ((cor != null) && (tamanho != null))