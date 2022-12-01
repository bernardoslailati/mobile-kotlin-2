package aula_2

// Exemplo: Enum
enum class NivelGuerreiro(val nome: String, val arma: Arma) {
    SOLDADO(nome = "Soldado", arma = Arma(nome = "Pistola", dano = 4)) {
        override fun superDano(): Int {
            return arma.dano * 1
        }
    },
    GUARDA(nome = "Guarda", arma = Arma(nome = "Escopeta", dano = 10)) {
        override fun superDano(): Int {
            return arma.dano * 1
        }
    },
    GENERAL(nome = "General", arma = Arma(nome = "Fuzil", dano = 14)) {
        override fun superDano(): Int {
            return arma.dano * 2
        }
    },
    CELESTIAL(nome = "Celestial", arma = Arma(nome = "Espada Celestial", dano = 30)) {
        override fun superDano(): Int {
            return arma.dano * 4
        }
    },
    APOCALIPTICO(nome = "Apocalíptico", arma = Arma(nome = "Machado das Trevas", dano = 65)) {
        override fun superDano(): Int {
            return arma.dano * 5
        }
    },
    DEUS_DOS_DEUSES(nome = "Deus dos Deuses", arma = Arma(nome = "Bíblia Sagrada", dano = 150)) {
        override fun superDano(): Int {
            return arma.dano * 10
        }
    };

    override fun toString(): String {
        return "NivelGuerreiro(nome=$nome, arma=$arma)"
    }

    abstract fun superDano(): Int

}

data class Arma(val nome: String, val dano: Int)

fun main() {

//    println(NivelGuerreiro.SOLDADO.toString())
//    println(NivelGuerreiro.SOLDADO.name)
//    println(NivelGuerreiro.SOLDADO.ordinal)

    println(NivelGuerreiro.SOLDADO.toString())
//    println(NivelGuerreiro.SOLDADO.arma)

}