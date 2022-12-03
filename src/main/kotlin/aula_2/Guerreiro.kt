package aula_2

import aula_2.NivelGuerreiro.*
import aula_3.Chefao

// Exemplo: Data Class
//
// O que possui de diferente de uma classe convencional?
//      (*) .toString() personalizado, para apresentar com clareza os valores dos atributos do objeto;
//      (**) Objetos dessa classe irão possuir por padrão o método.copy(), que possibilita criar um objeto com
//          todos os campos copiados de um primeiro objeto;
//      (***) .equals() e .hasCode() personalizados, se dois objetos tiverem todos os atributos com valores iguais,
//          a resposta será true (são iguais) para o .equals() e terão o mesmo valor de código hash.
data class Guerreiro(
    val nome: String,
    var vida: Int = VIDA_INICIAL,
    var nivel: NivelGuerreiro = NIVEL_INICIAL
) {

    companion object {
        const val VIDA_INICIAL = 20
        val NIVEL_INICIAL = SOLDADO

        var multiplicadorDano = 1
        fun buscarDescricao(): String {
            return "O guerreiro é um personagem que veio da Terra Média e vive nos anos de 900a.C ..."
        }
    }

    fun golpear(): Int {
        return nivel.arma.dano
    }

    fun golpeMultiplo(): Int {
        return nivel.arma.dano * multiplicadorDano
    }

    fun superGolpe(): Int {
        return nivel.superDano()
    }

    fun mudaNivel() {
        vida *= 2
        nivel = when(nivel) {
            SOLDADO -> GUARDA
            GUARDA -> GENERAL
            GENERAL -> CELESTIAL
            CELESTIAL -> APOCALIPTICO
            APOCALIPTICO -> DEUS_DOS_DEUSES
            else -> {
                vida /= 2
                println("Aviso: Nível máximo já alcançado!")
                nivel
            }
        }
    }

}

class Guerreiro2(
    val nome: String,
    var vida: Int = 20,
    var nivel: String
)

fun main() {
//
//    val guerreiro1 = Guerreiro(nome = "Adalberto Guerreiro", nivel = "Soldado")
//    // Uso do método copy()
//    val guerreiro2 = guerreiro1.copy()
//
//    val guerreiro3 = Guerreiro2(nome = "Adalberto Guerreiro", nivel = "Soldado")
//    val guerreiro4 = Guerreiro2(nome = "Adalberto Guerreiro", nivel = "Soldado")
//    // Objetos através de data class
//    println(guerreiro1.toString())
//    println(guerreiro2.toString())
//    println(guerreiro2.equals(guerreiro1))
//
//    // Objetos através de class
//    println(guerreiro3.toString())
//    println(guerreiro4.toString())
//    println(guerreiro4.equals(guerreiro3))
//    val guerreiroJoao = Guerreiro(nome = "João", nivel = "Soldado")
//    val guerreiroJose = Guerreiro(nome = "José", nivel = "Soldado")
//
//    println(Guerreiro.multiplicadorDano)
//    println(guerreiroJoao.golpeMultiplo())
//    println(guerreiroJose.golpeMultiplo())
//
//    println()
//
//    // usuário acabou de comprar o pacote premium de guerreiro
//    Guerreiro.multiplicadorDano = 2
//    println(Guerreiro.multiplicadorDano)
//    println(guerreiroJoao.golpeMultiplo())
//    println(guerreiroJose.golpeMultiplo())
//
//    println()
//
//    println(Guerreiro.buscarDescricao())

    val bartolomeuAmigoSeu = Guerreiro(nome = "Bartolomeu Amigo Seu")
    println(bartolomeuAmigoSeu)

    bartolomeuAmigoSeu.mudaNivel()
    println(bartolomeuAmigoSeu)

    bartolomeuAmigoSeu.mudaNivel()
    println(bartolomeuAmigoSeu)

    bartolomeuAmigoSeu.mudaNivel()
    println(bartolomeuAmigoSeu)

    bartolomeuAmigoSeu.mudaNivel()
    println(bartolomeuAmigoSeu)

    bartolomeuAmigoSeu.mudaNivel()
    println(bartolomeuAmigoSeu)

    bartolomeuAmigoSeu.mudaNivel()
    println(bartolomeuAmigoSeu)

    // bartolomeuAmigoSeu X belzeboss
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpear())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.golpeMultiplo())
    println(Chefao)
    Chefao.receberDano(bartolomeuAmigoSeu.superGolpe())
    println(Chefao)
}
