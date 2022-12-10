package aula_6

interface InstrumentoMusical {

    val possuiCordas: Boolean
        get() = false
    val material: String

    fun consertar()
    fun afinar()
    fun tocarMusica(musica: String)

    fun listaDeAcordes() {
        println("Dó Ré Mi Fá Sol La Si")
    }

}

class Violao(override val material: String) : InstrumentoMusical {

    override val possuiCordas: Boolean
        get() = true

    override fun consertar() {
        println("Trocar cordas.")
    }

    override fun afinar() {
        println("Regular cordas.")
    }

    override fun tocarMusica(musica: String) {
        println("Tocando música $musica LÁLÁLÁ...")
    }

}

fun main() {

    val meuViolao = Violao(material = "Madeira")
    meuViolao.listaDeAcordes()
    meuViolao.tocarMusica("Sei lá")

}
