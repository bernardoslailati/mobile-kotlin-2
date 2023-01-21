package desafios.aquario.menu

enum class MenuAquario(val opcao: Int) {
    ADICIONAR(1),
    ALIMENTAR(2),
    LIMPAR(3),
    UPGRADE(4),
    MOSTRAR(5),
    SAIR(0);

    companion object {
        private const val INICIO = "\nBem-vindo ao sistema de gerenciamento de aquário!\nO que deseja fazer?"

        private val menu = Menu()
        fun emExecucao(): Boolean = menu.emExecucao()
        fun fecharSistema() {
            menu.fecharSistema()
        }

        private fun mostrarOpcoes() {
            println(INICIO)
            values().forEach { println("${it.opcao} - ${it.name}") }
            print("\n==> ")
        }

        fun obterAcao(): Int {
            mostrarOpcoes()
            return readlnInt()
        }
    }
}