package modal;

public abstract class Conta {

    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public String getTipo() {
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}
