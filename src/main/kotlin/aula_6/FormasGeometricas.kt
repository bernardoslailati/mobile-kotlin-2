package aula_6

import kotlin.math.PI
import kotlin.math.pow

open class Forma {
    open val unidade: String = ""
}

// calcular area
open class Forma2D(override val unidade: String): Forma() {

    open val area: Double = 0.0
    open fun calculaArea(): String {
        return ""
    }

}

// calcular volume
open class Forma3D(override val unidade: String): Forma() {
    open val volume: Double = 0.0
    open fun calculaVolume(): String {
        return ""
    }
}

// Circulo, Triangulo, Quadrado...
class Circulo(val raio: Double, unidade: String) : Forma2D(unidade) {

    override val area: Double = PI * raio.pow(2.0)
    override fun calculaArea(): String {
        return "$area $unidade²"
    }

}

// Pirâmide, Cone, Cilindro, ...
class Piramide(val areaBase: Double, val altura: Double, unidade: String) : Forma3D(unidade) {

    override val volume: Double = areaBase * altura / 3
    override fun calculaVolume(): String {
        return "$volume $unidade³"
    }

}

class Cone(val raio: Double, val altura: Double, unidade: String) : Forma3D(unidade) {

    override val volume: Double = PI * raio.pow(2.0) * altura / 3
    override fun calculaVolume(): String {
        return "$volume $unidade³"
    }

}


fun main() {

    val meuCirculo = Circulo(raio = 4.0, unidade = "cm")
    println(meuCirculo.calculaArea())

    val meuCone = Cone(raio = 4.0, altura = 2.0, unidade = "mm")
    println(meuCone.calculaVolume())

    val minhaPiramide = Piramide(areaBase = 200.0, altura = 450.0, unidade = "m")
    println(minhaPiramide.calculaVolume())

}