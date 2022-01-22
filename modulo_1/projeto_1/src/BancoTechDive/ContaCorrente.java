package BancoTechDive;

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

        Cliente cliente = getCliente();

        double limite = cliente.getRenda() * 0.5;

        return limite;
    }
}
