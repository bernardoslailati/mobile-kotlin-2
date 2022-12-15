package aula_8

import aula_8.DificuldadeQuestao.*

class Questao<T>(
    val texto: String,
    val resposta: T,
    val dificuldade: DificuldadeQuestao
) {
    fun mostraResposta(): T {
        println(
            "A resposta correta é: ${
                when(resposta) {
                    is Boolean -> if (resposta) "VERDADEIRO" else "FALSO"
                    else -> resposta.toString()
                }
            }."
        )
        return resposta
    }
}

enum class DificuldadeQuestao {
    FACIL, MEDIA, DIFICIL
}

fun main() {
    val questao1 =
        Questao(texto = "Quem descobriu o Brasil foi ____________.", resposta = "Pedro Alvares Cabral", dificuldade = FACIL)
    val questao2 =
        Questao(texto = "Qual o valor de x? 29x + 19 = -182", resposta = -6.93103, dificuldade = MEDIA)
    val questao3 =
        Questao(texto = "Manga com leite mata. VERDADEIRO ou FALSO?", resposta = true, dificuldade = DIFICIL)
}