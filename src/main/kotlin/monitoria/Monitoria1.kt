package monitoria

// get() = retornar o valor de um atributo
// set(value) = inserir um valor para o atributo

class Ator(val nome: String, val sobrenome: String) {

    var ultimoFilme: String? = null
        get() {
            // se o valor do último filme for null, ou seja, o ator nunca estrelou nenhum filme, quero retornar a string
            // "Desconhecido"
            return if (field == null) "Desconhecido" else field
        }
        set(value) {
            // se tentar passar uma string vazia, informar (println) que o filme é inválido
            value?.apply {
                if (this.isEmpty())
                    println("Esse filme é inválido!")
                else
                    field = value
            }
        }

}



fun main() {

    val theRock = Ator(nome = "Dwayne", sobrenome = "Johnson")

    println("O último filme do ator ${theRock.nome} ${theRock.sobrenome} foi ${theRock.ultimoFilme}.")

    // set(value)
    theRock.ultimoFilme = ""

    // get()
    println("O último filme do ator ${theRock.nome} ${theRock.sobrenome} foi ${theRock.ultimoFilme}.")

    theRock.ultimoFilme = "Adão Negro"

    println("O último filme do ator ${theRock.nome} ${theRock.sobrenome} foi ${theRock.ultimoFilme}.")

}