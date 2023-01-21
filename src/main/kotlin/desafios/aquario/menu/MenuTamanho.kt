package desafios.aquario.menu

enum class MenuTamanho(val opcao: Int) {
    PEQUENO(1),
    MEDIO(2),
    GRANDE(3),
    SAIR(0);

    companion object {
        private const val INICIO = "Escolha o tamanho do seu peixe:"

        private val menu = Menu()

        private fun mostrarOpcoes() {
            if (!menu.emExecucao()) menu.resetarSistema()
            println(INICIO)
            values().forEach { println("${it.opcao} - ${it.name}") }
        }

        private fun obterAcao(): Int {
            if (!menu.emExecucao()) menu.resetarSistema()
            mostrarOpcoes()
            return readlnInt()
        }

        fun escolherTamanho(): String? {
            menu.resetarSistema()
            var tamanhoEscolhido: String? = null
            while (menu.emExecucao()) {
                tamanhoEscolhido = when (val acao = obterAcao()) {
                    PEQUENO.opcao, MEDIO.opcao, GRANDE.opcao -> {
                        menu.fecharSistema()
                        values().find { it.opcao == acao }?.name ?: "Desconhecido"
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
            return tamanhoEscolhido
        }
    }
}