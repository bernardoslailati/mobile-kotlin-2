package desafios.aquario.modelos

data class Peixe(val cor: String, val tamanho: String) {

    fun toStringIndexed(index: Int): String {
        return "[$index] Peixe $cor $tamanho"
    }

}