package desafios.carteiras_bancarias.modelos.carteiras

enum class Operacoes(val descricao: String) {
    DEPOSITO("Depósito"),
    SAQUE("Saque"),
    INVESTIMENTO("Investimento"),
    GUARDAR("Guardar"),
    RECEBER_TRANSFERENCIA("Transferência Recebida"),
    PAGAR_BOLETO("Pagar Boleto"),
    TRANSFERENCIA_PIX("Transferência Pix")
}

interface OperacoesGerais {
    fun pagarBoleto(valor: Double)
}

interface OperacoesFisicas : OperacoesGerais {
    fun deposito(valor: Double)
    fun saque(valor: Double)
}

interface OperacoesDigitais : OperacoesGerais {
    fun transferenciaPix(valor: Double)
    fun investir(valor: Double)
    fun guardar(valor: Double)
    fun receberTransferencia(valor: Double)
}