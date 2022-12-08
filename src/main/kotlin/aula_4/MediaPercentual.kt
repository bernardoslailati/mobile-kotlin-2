package aula_4

// Propriedades e funções de extensão
data class Nota(val valor: Double, val valorMaximo: Double)

val List<Nota>.mediaPercentual: Double
    get() {
        var totalRecebido = 0.0
        var totalDistribuido = 0.0

        this.forEach { nota ->
            totalRecebido += nota.valor
            totalDistribuido += nota.valorMaximo
        }

        return totalRecebido / totalDistribuido * 100
    }

fun main() {

    val listaNotas: List<Nota> = listOf(
        Nota(valor = 6.5, valorMaximo = 10.0),
        Nota(valor = 8.5, valorMaximo = 15.0),
        Nota(valor = 2.5, valorMaximo = 10.0),
        Nota(valor = 9.0, valorMaximo = 20.0),
        Nota(valor = 10.0, valorMaximo = 10.0)
    )

    println("A média percentual das notas é ${String.format("%.2f", listaNotas.mediaPercentual)}%.")

}