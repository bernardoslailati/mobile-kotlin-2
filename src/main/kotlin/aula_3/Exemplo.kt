package aula_3

enum class Cores(val valor: Int) {
    VERDE(1),
    AZUL(2);

    companion object {
        val multiplicador = 10.0
    }

    fun minhaFuncao(): Int {
        println("oi")
        return multiplicador.toInt() * valor
    }

    val outroMultiplicador = 11.0
}

fun main() {

    val azul = Cores.multiplicador

}