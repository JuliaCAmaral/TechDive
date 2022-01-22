package modal;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, double saldoInicial) {
        super(cliente, saldoInicial);
    }

    public String getTipo() {
        return "Conta corrente";
    }
}
