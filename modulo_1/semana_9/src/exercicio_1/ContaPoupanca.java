package exercicio_1;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String nomeCliente, double saldoInicial) {
        super(nomeCliente, saldoInicial);
    }

    public String getTipo() {
        return "Conta poupança";
    }
}
