package aula_6

interface InstrumentoMusical {

    val possuiCordas: Boolean
        get() = false
    val material: String

    fun consertar()
    fun afinar()
    fun afinar(corda: String)
    fun tocarMusica(musica: String)

    fun listaDeAcordes() {
        println("Dó Ré Mi Fá Sol La Si")
    }

}

interface CordasInstrumento {
    val numeroCordas: Int
    val materialCordas: String

    fun trocarCordas()
}

class Violao(override val material: String) : InstrumentoMusical, CordasInstrumento {

    override val possuiCordas: Boolean
        get() = true

    override fun consertar() {
        println("Trocar cordas.")
    }

    override fun afinar() {
        println("Regular cordas.")
    }

    override fun afinar(corda: String) {
        println("Corda $corda afinada!")
    }

    override fun tocarMusica(musica: String) {
        println("Tocando música $musica LÁLÁLÁ...")
    }

    override val numeroCordas: Int = 6
    override val materialCordas: String = "Nailon" // ou "Aço"

    override fun trocarCordas() {
        println("Cordas trocadas com sucesso!")
    }

}

fun main() {

    val meuViolao = Violao(material = "Madeira")
    meuViolao.listaDeAcordes()
    meuViolao.tocarMusica("Sei lá")

}
