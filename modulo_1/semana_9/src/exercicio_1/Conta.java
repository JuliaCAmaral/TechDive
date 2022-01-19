package exercicio_1;

public abstract class Conta {

    private String nomeCliente;
    private double saldoInicial;

    public Conta(String nomeCliente, double saldoInicial) {
        this.nomeCliente = nomeCliente;
        this.saldoInicial = saldoInicial;
    }

    public String getTipo() {
        return null;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }
}
