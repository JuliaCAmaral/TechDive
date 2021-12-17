package exercicio6;

public class Vendedor extends Empregado {

    private double valorVendas;

    private double comissao;

    public double calculaComissao() {
        double comissaoCalculada = this.valorVendas * (this.comissao/100);
        return comissaoCalculada;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario(int codigoSetor) {

        double salarioVendedor = super.calcularSalario(codigoSetor) + calculaComissao();
        return salarioVendedor;
    }

    @Override
    protected String getTipo() {
        return "Vendedor";
    }

    @Override
    public String toString() {
        return String.format("%n%s - %s: Contato: %s, %s",getTipo(), getNome(), getTelefone(), getEndereco());
    }
}
