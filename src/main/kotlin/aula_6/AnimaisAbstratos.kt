package aula_6

abstract class Animal(private val nome: String) {

    abstract val numeroPatas: Int
    private var tamanho: Int = 0

    fun descricao() {
        println("O animal é $nome.")
    }

    abstract fun alimentar()
    abstract fun emitirSom()

}

class Elefante(override val numeroPatas: Int = 4) : Animal(nome = "Elefante") {

    override fun alimentar() {
        println("Comer folhas e frutas.")
    }

    override fun emitirSom() {
        println("FUUMM UUUUH! BRUUUUN!")
    }

}

class Peixe: Animal(nome = "Peixe") {

    override val numeroPatas: Int = 0

    override fun alimentar() {
        println("Comer plantas aquáticas e ração.")
    }

    override fun emitirSom() {
        println("GLUBGLUB!")
    }

}

fun main() {

    val meuElefante = Elefante(4)
    meuElefante.descricao()
    meuElefante.alimentar()
    meuElefante.emitirSom()

    val meuPeixe = Peixe()
    meuPeixe.descricao()
    meuPeixe.alimentar()
    meuPeixe.emitirSom()

}