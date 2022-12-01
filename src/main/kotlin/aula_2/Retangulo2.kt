package aula_2

// Se inicializa com var comprimento = comprimento dá errado pq não verifica
// Se faz pelo construtor primário e verifica em init não consegue ter set ou get

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