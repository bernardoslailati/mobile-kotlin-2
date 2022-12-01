package aula_2

// Exemplo: Data Class
//
// O que possui de diferente de uma classe convencional?
//      (*) .toString() personalizado, para apresentar com clareza os valores dos atributos do objeto;
//      (**) Objetos dessa classe irão possuir por padrão o método.copy(), que possibilita criar um novo objeto com
//          todos os campos copiados de um primeiro objeto;
//      (***) .equals() e .hasCode() personalizados, se dois objetos tiverem todos os atributos com valores iguais,
//          a resposta será true (são iguais) para o .equals() e terão o mesmo valor de código hash.
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
