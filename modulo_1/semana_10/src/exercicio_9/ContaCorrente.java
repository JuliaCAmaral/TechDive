package exercicio_9;

public class ContaCorrente extends Conta {
    public ContaCorrente(int numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }

    @Override
    protected String getTipo() {
        return "Conta Corrente";
    }

    @Override
    protected double getLimite() {

        double limite = 500;

        return limite;
    }
}
