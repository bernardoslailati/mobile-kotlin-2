package aula_2

import aula_2.NivelGuerreiro.*
import aula_3.Chefao
import kotlin.random.Random

// Exemplo: Data Class
//
// O que possui de diferente de uma classe convencional?
//      (*) .toString() personalizado, para apresentar com clareza os valores dos atributos do objeto;
//      (**) Objetos dessa classe irão possuir por padrão o método.copy(), que possibilita criar um objeto com
//          todos os campos copiados de um primeiro objeto;
//      (***) .equals() e .hasCode() personalizados, se dois objetos tiverem todos os atributos com valores iguais,
//          a resposta será true (são iguais) para o .equals() e terão o mesmo valor de código hash.

// Uma CASA e ANIMAL DE ESTIMACAO -> internas do Guerreiro
data class Guerreiro(
    val nome: String,
    var vida: Int = VIDA_INICIAL,
    var nivel: NivelGuerreiro = NIVEL_INICIAL,
    var casa: Casa? = null
) {

    var animalDeEstimacao: AnimalDeEstimacao? = null

    // Nested Class -> será possivelmente acessada de forma externa
    data class Casa(val tamanho: Int, val recuperacao: Int) {
        fun descansar() {
            // Aumentar a vida do guerreiro somando "recuperacao"
        }
    }

    // Inner Class -> acessível apenas internamente no escopo do Guerreiro
    inner class AnimalDeEstimacao(val nome: String, val dano: Int) {
        private val multiplicadorDeDano = Random.nextInt(1, 2)
        fun golpear(): Int {
            return dano * multiplicadorDeDano
        }
    }

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
        return nivel.superDano() + (animalDeEstimacao?.dano ?: 0)
    }

    fun ganhouUmCachorro(animal: AnimalDeEstimacao) {
        animalDeEstimacao = animal
    }

    fun mudaNivel() {
        vida *= 2
        nivel = when(nivel) {
            SOLDADO -> GUARDA
            GUARDA -> GENERAL
            GENERAL -> {
                animalDeEstimacao = AnimalDeEstimacao(nome = "Unicórnio", dano = 80)
                CELESTIAL
            }
            CELESTIAL -> {
                animalDeEstimacao = AnimalDeEstimacao(nome = "Dragão Negro de Olhos Vermelhos", dano = 120)
                APOCALIPTICO
            }
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
    // Criando um objeto do tipo Guerreiro
    val guerreiro1 = Guerreiro(nome = "Adalberto Guerreiro")
    // Uso do método copy()
    val guerreiro2 = guerreiro1.copy()

    val guerreiro3 = Guerreiro2(nome = "Adalberto Guerreiro", nivel = "Soldado")
    val guerreiro4 = Guerreiro2(nome = "Adalberto Guerreiro", nivel = "Soldado")
    // Objetos através de data class
    println(guerreiro1.toString())
    println(guerreiro2.toString())
    // A função .equals() (representada por ==)
    println(guerreiro2 == guerreiro1)

    // Objetos através de class
    println(guerreiro3.toString())
    println(guerreiro4.toString())
    // A função .equals() (representada por ==)
    println(guerreiro4 == guerreiro3)
    val guerreiroJoao = Guerreiro(nome = "João")
    val guerreiroJose = Guerreiro(nome = "José")

    println(Guerreiro.multiplicadorDano)
    println(guerreiroJoao.golpeMultiplo())
    println(guerreiroJose.golpeMultiplo())

    println()

    // Usuário acabou de comprar o pacote premium de guerreiro... seu dano será maior!
    Guerreiro.multiplicadorDano = 2
    println(Guerreiro.multiplicadorDano)
    println(guerreiroJoao.golpeMultiplo())
    println(guerreiroJose.golpeMultiplo())

    println()

    println(Guerreiro.buscarDescricao())

    // Guerreiro ganhou uma casa! Comprou com diamantes (dinheiro)

    val casaPremium = Guerreiro.Casa(tamanho = 100, recuperacao = 200)
    guerreiroJoao.casa = casaPremium

//    guerreiroJoao.ganhouUmCachorro(Guerreiro.AnimalDeEstimacao()) // ERRO -> não é possível
//    instanciar um AnimalDeEstimacao fora da classe principal

}
