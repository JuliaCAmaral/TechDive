package exercicio6;

public class Vendedor extends Empregado {

    private double valorVendas;

    private double comissao;

    public double calculaComissao() {

        return this.valorVendas * (this.comissao/100);
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

        return super.calcularSalario(codigoSetor) + calculaComissao();
    }

    @Override
    protected String getTipo() {
        return "Vendedor";
    }

}
