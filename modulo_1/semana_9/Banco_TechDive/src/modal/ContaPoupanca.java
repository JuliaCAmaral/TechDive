package modal;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, double saldoInicial) {
        super(cliente, saldoInicial);
    }

    public String getTipo() {
        return "Conta poupança";
    }
}
