package exercicio_1;

public class ContaCorrente extends Conta {

    public ContaCorrente(String nomeCliente, double saldoInicial) {
        super(nomeCliente, saldoInicial);
    }

    public String getTipo() {
        return "Conta corrente";
    }
}
