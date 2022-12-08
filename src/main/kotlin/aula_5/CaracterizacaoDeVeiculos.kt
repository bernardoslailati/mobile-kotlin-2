package aula_5

// Herança
open class Veiculo(val capacidade: Int)

open class Terrestre(capacidade: Int, val numeroDeRodas: Int) : Veiculo(capacidade)

open class Automovel(
    capacidade: Int,
    numeroDeRodas: Int,
    val cor: String,
    val placa: String,
    val modelo: String
) : Terrestre(capacidade, numeroDeRodas) {

    open fun possuiRe(): Boolean = false

}

class Carro(
    capacidade: Int,
    cor: String,
    placa: String,
    modelo: String,
    val numPortas: Int,
    val potenciaCv: Int
) : Automovel(capacidade, NUM_RODAS, cor, placa, modelo) {

    companion object {
        private const val NUM_RODAS = 4
    }

    override fun possuiRe(): Boolean = true

}

class Moto(
    cor: String,
    placa: String,
    modelo: String,
    val cilindradas: Int
) : Automovel(CAPACIDADE, NUM_RODAS, cor, placa, modelo) {

    companion object {
        private const val CAPACIDADE = 2
        private const val NUM_RODAS = 2
    }

}

fun main() {

    val carroDaUdimile = Carro(
        capacidade = 5,
        cor = "Vermelho",
        placa = "ABC12E4",
        modelo = "Up!",
        numPortas = 5,
        potenciaCv = 450
    )

    val motoDeRubens = Moto(
        cor = "Prateado",
        placa = "ABC12E5",
        modelo = "XRE",
        cilindradas = 300
    )

    motoDeRubens.possuiRe()

}



