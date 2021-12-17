package exercicio5;

public class Fornecedor extends Pessoa {

    private double valorCredito;

    private double valorDivida;

    public double obterSaldo() {
        double saldo;
        saldo = this.valorCredito - this.valorDivida;
        return saldo;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    @Override
    public String toString() {
        return String.format("%n%s - %s: Contato: %s, %s.\nPossui saldo: R$ %.2f ",
                getTipo(), getNome(), getTelefone(), getEndereco(), obterSaldo());
    }

    @Override
    protected String getTipo() {
        return "Fornecedor";
    }
}
