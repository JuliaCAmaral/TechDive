package BancoTechDive;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }

    @Override
    protected String getTipo() {
        return "Conta Poupança";
    }
}
