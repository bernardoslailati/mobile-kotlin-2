package desafios.aquario.menu

enum class MenuCor(val opcao: Int) {
    AMARELO(1),
    AZUL(2),
    VERMELHO(3),
    SAIR(0);

    companion object {
        private const val INICIO = "Escolha a cor do seu peixe:"

        private val menu = Menu()

        private fun mostrarOpcoes() {
            println(INICIO)
            values().forEach { println("${it.opcao} - ${it.name}") }
        }

        private fun obterAcao(): Int {
            mostrarOpcoes()
            return readlnInt()
        }

        fun escolherCor(): String? {
            menu.resetarSistema()
            var corEscolhida: String? = null
            while (menu.emExecucao()) {
                corEscolhida = when (val acao = obterAcao()) {
                    AMARELO.opcao, AZUL.opcao, VERMELHO.opcao -> {
                        menu.fecharSistema()
                        values().find { it.opcao == acao }?.name ?: "Desconhecida"
                    }
                    SAIR.opcao -> {
                        menu.fecharSistema()
                        null
                    }
                    else -> {
                        println("Opção inválida. Tente novamente...")
                        null
                    }
                }
            }
            return corEscolhida
        }
    }
}