package desafios.aquario.modelos

data class Aquario(val peixes: MutableList<Peixe> = mutableListOf(), var capacidade: Int = CAPACIDADE_INICIAL) {

    companion object {
        const val CAPACIDADE_INICIAL = 5
        var constanteSujeira = 3
        const val MENSAGEM_AQUARIO_SUJO =
            "Aquário está sujo... Não é possível adicionar o peixe com o aquário nesse estado. Limpe-o e assim poderá adicionar mais peixes."
        const val MENSAGEM_CAPACIDADE_MAXIMA_ATINGIDA =
            "Falha ao adicionar peixe... A capacidade máxima do aquário foi atingida, faça o upgrade para aumentá-la."
    }

    private var estaSujo = false

    fun adicionar(peixe: Peixe) {
        println(
            if (peixes.size + 1 <= capacidade) {
                if ((peixes.size > 0 && (peixes.size % constanteSujeira == 0)) && !estaSujo && !executadaLimpeza) {
                    estaSujo = true
                    MENSAGEM_AQUARIO_SUJO
                } else {
                    if (!estaSujo) {
                        executadaLimpeza = false
                        peixes.add(peixe)
                        "Peixe ${peixe.cor} e ${peixe.tamanho} adicionado ao aquário com sucesso!"
                    } else
                        MENSAGEM_AQUARIO_SUJO
                }
            } else
                MENSAGEM_CAPACIDADE_MAXIMA_ATINGIDA
        )
    }

    fun alimentar() {
        println(
            when (val resposta = RespostaAlimentar.sortear(totalPeixes = peixes.size)) {
                is RespostaAlimentar.Falha -> "FALHA: " + resposta.mensagem
                is RespostaAlimentar.Parcial -> "PARCIAL: " + resposta.mensagem
                is RespostaAlimentar.Sucesso -> "SUCESSO: " + resposta.mensagem
            }
        )
    }

    private var executadaLimpeza = false

    fun limpar() {
        println(
            if (estaSujo) {
                estaSujo = false
                executadaLimpeza = true
                "Limpeza do aquário realizada com sucesso!"
            } else
                "O aquário não necessita de limpeza pois já está limpo."
        )
    }

    fun mostrarPeixes() {
        var index = 0
        println(
            peixes.joinToString(
                prefix = "Lista de peixes do aquário:\n",
                separator = "\n",
                transform = {
                    index++
                    it.toStringIndexed(index)
                },
                postfix = if (peixes.isEmpty()) "O aquário não possui nenhum peixe." else ""
            )
        )
    }

    fun upgrade() {
        print("A capacidade de peixes no aquário foi aumentada de $capacidade")
        capacidade *= 2
        println(" para $capacidade!")
    }

}

sealed class RespostaAlimentar {
    class Sucesso(val totalPeixes: Int) : RespostaAlimentar() {
        val mensagem: String
            get() = "Todos os peixes ($totalPeixes) se alimentaram."
    }

    class Falha(val mensagem: String) : RespostaAlimentar()
    class Parcial(val peixesAlimentados: Int) : RespostaAlimentar() {
        val mensagem: String
            get() = "Apenas uma parte dos peixes se alimentaram ($peixesAlimentados)."
    }

    companion object {
        fun sortear(totalPeixes: Int): RespostaAlimentar {
            return if (nenhumPeixeNoAquario(totalPeixes))
                Falha(mensagem = "O aquário se encontra vazio. Adicione peixes para então alimentá-los.")
            else
                when ((1..3).random()) {
                    1 -> Sucesso(totalPeixes = totalPeixes)
                    2 -> Falha(mensagem = "Nenhum peixe se alimentou.")
                    3 -> {
                        if (apenasUmPeixeNoAquario(totalPeixes))
                            Sucesso(totalPeixes = totalPeixes)
                        else {
                            val peixesAlimentadosRandomico = (1 until totalPeixes).random()
                            Parcial(peixesAlimentados = peixesAlimentadosRandomico)
                        }
                    }

                    else -> Falha(mensagem = "Nenhum peixe se alimentou.")
                }
        }

        private fun nenhumPeixeNoAquario(totalPeixes: Int) = totalPeixes == 0

        private fun apenasUmPeixeNoAquario(totalPeixes: Int) = totalPeixes == 1
    }

}
