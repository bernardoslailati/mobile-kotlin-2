package desafios.aquario

import desafios.aquario.menu.MenuAquario
import desafios.aquario.menu.MenuAquario.*
import desafios.aquario.menu.MenuPeixe
import desafios.aquario.menu.OPCAO_INVALIDA
import desafios.aquario.modelos.Aquario

fun main() {

    val aquario = Aquario()

    while (MenuAquario.emExecucao()) {
        when (MenuAquario.obterAcao()) {
            ADICIONAR.opcao -> {
                val peixe = MenuPeixe.escolherPeixe()
                peixe?.let {
                    aquario.adicionar(peixe)
                }
            }
            ALIMENTAR.opcao -> aquario.alimentar()
            LIMPAR.opcao -> aquario.limpar()
            UPGRADE.opcao -> aquario.upgrade()
            MOSTRAR.opcao -> aquario.mostrarPeixes()
            SAIR.opcao -> MenuAquario.fecharSistema()
            OPCAO_INVALIDA -> {}
            else -> {
                println("Opção inválida. Tente novamente...")
            }
        }
    }

}



