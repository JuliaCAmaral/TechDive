package exercicio5;

public class Operario extends Empregado {

    private double valorProducao;

    private double porcentagemComissao;

    public double comissao() {
        double comissao = this.valorProducao * (porcentagemComissao/100);
        return comissao;
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

        double salarioOperario = super.calcularSalario(codigoSetor) + comissao();
        return salarioOperario;
    }

    @Override
    protected String getTipo() {
        return "Operario";
    }

    @Override
    public String toString() {
        return String.format("%n%s - %s: Contato: %s, %s",getTipo(), getNome(), getTelefone(), getEndereco());
    }

}
