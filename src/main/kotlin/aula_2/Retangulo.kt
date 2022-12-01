package aula_2

// Exemplo: Getters e Setters
class Retangulo(val comprimento: Double, larguraInicial: Double) {

    var largura: Double = larguraInicial
        set(value) {
            field = if (value > 0) value else 0.0
        }

    val area: Double
        get() = comprimento * largura

    fun calculaVolume() {
        // larguraInicial, não pode utilizar aqui dentro! Apenas existe no formato de parâmetro dentro do escopo da função constructor (primário)
        largura
        // ...
    }

}

fun main() {

    val meuRetangulo = Retangulo(comprimento = 10.0, larguraInicial = -2.0)

    println("Largura: ${meuRetangulo.largura}")
    println("Area: ${meuRetangulo.area}")

    // set(value) sendo executado!
    // set(-2.0) {
    //      largura = -2.0
    // }
    meuRetangulo.largura = -2.0

    // get sendo executado!
    // get(): Double {
    //      return largura * comprimento    =>  -2.0 * 10.0
    // }
    println("Nova Largura: ${meuRetangulo.largura}")

}