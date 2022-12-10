package aula_6

open class Carro(
    protected val marca: String,
    protected val modelo: String,
    protected val ano: Int,
    var potenciaCv: Int
) {
    open fun descricao() {
        println("O carro é da marca $marca, modelo $modelo, ano $ano e possui ${potenciaCv}cv de potência.")
    }
}


class Up(val eConversivel: Boolean = false): Carro(marca = "Volkswagen", modelo = "Up", ano = 2018, potenciaCv = 200) {

    override fun descricao() {
        super.descricao()
        println("(!) Este veículo ${if (eConversivel) "é" else "não é"} conversível.")
    }

    fun aumentaPotencia(potencialAdicional: Int) {
        potenciaCv += potencialAdicional
        println("VRUUM! A potência foi aumentada! Seu $marca $modelo $ano agora possui a potência de ${potenciaCv}cv.")
    }

}

fun main() {
    val meuUp = Up()
    meuUp.descricao()
    meuUp.aumentaPotencia(100)

    val meuSegundoUp = Up(eConversivel = true)
    meuSegundoUp.descricao()
}