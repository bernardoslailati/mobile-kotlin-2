package aula_8


//abstract class CalculadoraGenerica(val primeiroValor: Any, val segundoValor: Any) {
//    abstract fun soma(): Any
//    abstract fun subtrai(): Any
//    fun descricaoValores() {
//        println("Os dois valores ($primeiroValor e $segundoValor) são do tipo ${primeiroValor!!::class}")
//    }
//}

abstract class CalculadoraGenerica<T>(val primeiroValor: T, val segundoValor: T) {
    abstract fun soma(): T
    abstract fun subtrai(): T
    fun descricaoValores() {
        println("Os dois valores ($primeiroValor e $segundoValor) são do tipo ${primeiroValor!!::class}")
    }
}

class CalculadoraString(primeiroValor: String, segundoValor: String) :
    CalculadoraGenerica<String>(primeiroValor, segundoValor) {
    override fun soma(): String {
        return "$primeiroValor $segundoValor"
    }

    override fun subtrai(): String {
        return primeiroValor.replace(segundoValor, "")
    }
}

class CalculadoraInt(primeiroValor: Int, segundoValor: Int): CalculadoraGenerica<Int>(primeiroValor, segundoValor) {
    override fun soma(): Int {
        return primeiroValor + segundoValor
    }

    override fun subtrai(): Int {
        return primeiroValor - segundoValor
    }
}

fun main() {

    val minhaCalculadoraString = CalculadoraString(primeiroValor = "abcdef", segundoValor = "abc")

    with(minhaCalculadoraString) {
        println(primeiroValor)
        println(segundoValor)
        descricaoValores()
        println(soma())
        println(subtrai())
    }

    val minhaCalculadoraInt = CalculadoraInt(primeiroValor = 10, segundoValor = 10)

    with(minhaCalculadoraInt) {
        println(primeiroValor)
        println(segundoValor)
        descricaoValores()
        println(soma())
        println(subtrai())
    }

}