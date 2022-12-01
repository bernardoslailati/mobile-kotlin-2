package aula_2

// Exercício em Aula: Getters e Setters - feito por João Victor (para tirar dúvidas)
//
// O que foi feito?
//
// Maneira de fazer com que o construtor receba PARÂMETROS (comprimento: Double, largura: Double) a serem inseridos nos
// ATRIBUTOS da classe (comprimento, linha 14 e largura, linha 23), passando pelas regras definidas nos SETS
// desses atributos (comprimento e largura não podem ser menor que 0).
//
// Além disso, os valores dos PARÂMETROS passados no construtor, também são validados através do bloco init
// ("Comprimento e largura não podem ser negativos").

class Retangulo2(comprimento: Double, largura: Double) {

    var comprimento: Double = .0
        get() = comprimento
        set(value) {
            if (value < 0)
                throw ArithmeticException("Comprimento não pode ser negativo")

            field = value
        }

    var largura: Double = .0
        get() = largura
        set(value) {
            if (value < 0)
                throw ArithmeticException("Largura não pode ser negativa")
            field = value
        }

    init {
        if (comprimento < 0 || largura < 0)
            throw ArithmeticException("Comprimento e largura não podem ser negativos")

        this.comprimento = comprimento
        this.largura = largura
    }

}