package aula_2

// Exemplo: Data Class (possuem .toString() personalizado, os objetos possuem
// por padrão o método.copy()
data class Guerreiro(
    val nome: String,
    var vida: Int = 20,
    var nivel: String
) {

    fun mudaNivel(novoNivel: String) {
        nivel = novoNivel
    }

}

class Guerreiro2(
    val nome: String,
    var vida: Int = 20,
    var nivel: String
)

fun main() {

    val guerreiro1 = Guerreiro(nome = "Adalberto Guerreiro", nivel = "Soldado")
    val guerreiro2 = guerreiro1.copy()

    val guerreiro3 = Guerreiro2(nome = "Adalberto Guerreiro", nivel = "Soldado")
    val guerreiro4 = Guerreiro2(nome = "Adalberto Guerreiro", nivel = "Soldado")

    // Objetos através de data class
    println(guerreiro1.toString())
    println(guerreiro2.toString())
    println(guerreiro2.equals(guerreiro1))

    // Objetos através de class
    println(guerreiro3.toString())
    println(guerreiro4.toString())
    println(guerreiro4.equals(guerreiro3))

}
