package aula_4

class ClassePrincipal(val teste: Int) {
    var descricao1 = "Classe Principal"

    class aninhada {
        var descricao2 = "Classe Aninhada"
        fun teste(): String {
//            return descricao1 // ERRO -> Não é possível acessar atributos da classe principal em classes aninhadas
            return ""
        }
    }

    inner class ClasseDeDentro {
        var descricao3 = "Classe de Dentro"
        fun teste(): String {
            return descricao1
        }
    }
}

data class JogadorSelecao(val nome: String, val posicao: String, val numero: Int) {
    inner class Chuteira(val cor: Int)
    class Lesoes(val jogadoresLesionados: MutableList<String> = mutableListOf()) {
        inner class GravidadeLesao(val nivelGravidade: Int)
    }
}

fun main() {

//    val lesoes = JogadorSelecao(nome = "Messi", posicao = "ATA", numero = 10).Lesoes() // ERRO -> não é possível
//    instanciar classes aninhadas a partir de objetos da classe principal! Apenas de forma abstrata =>
//    nomeDaClassePrincipal.nomeDaClasseAninhada

    val lesoes = JogadorSelecao.Lesoes(jogadoresLesionados = mutableListOf("Messi"))
    val gravidadeLesao: JogadorSelecao.Lesoes.GravidadeLesao =
        JogadorSelecao.Lesoes().GravidadeLesao(nivelGravidade = 1)

    val jogador = JogadorSelecao(nome = "Messi", posicao = "ATA", numero = 10).Chuteira(cor = 1)

    val gravidadeLesao2: JogadorSelecao.Chuteira =
//        JogadorSelecao.GravidadeLesao2(nivelGravidade = 2) => ERRO! Não é possível criar um objeto de uma inner class
//        de forma abstrata (nomeDaClassePrincipal.nomeDaClasseInner(...)), apenas atrvés de um objeto da classe principal
        JogadorSelecao(nome = "Messi", posicao = "ATA", numero = 10).Chuteira(cor = 2)
}