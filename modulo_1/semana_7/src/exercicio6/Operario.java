package exercicio6;

public class Operario extends Empregado {

    private double valorProducao;

    private double porcentagemComissao;

    public double comissao() {

        return this.valorProducao * (porcentagemComissao/100);
    }

    public void setPorcentagemComissao(double porcentagemComissao) {
        this.porcentagemComissao = porcentagemComissao;
    }

    public double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(double valorProducao) {
        this.valorProducao = valorProducao;
    }

    @Override
    public double calcularSalario(int codigoSetor) {

        return super.calcularSalario(codigoSetor) + comissao();
    }

    @Override
    protected String getTipo() {
        return "Operario";
    }


}
