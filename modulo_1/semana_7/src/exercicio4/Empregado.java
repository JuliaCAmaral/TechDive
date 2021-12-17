package exercicio4;

public class Empregado extends Pessoa {

    private int codigoSetor;

    private double salarioBase;

    private double imposto = 23;

    public double calcularSalario(int codigoSetor) {

        switch (codigoSetor) {
            case 1:
                this.salarioBase = 2000;
                break;

            case 2:
                this.salarioBase = 3500;
                break;

            case 3:
                this.salarioBase = 5000;
                break;

            case 4:
                this.salarioBase = 7800;
                break;

        }

        double salarioLiquido;

        salarioLiquido = this.salarioBase * (1 - (this.imposto/100));

        return salarioLiquido;

    }

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    @Override
    public String toString() {
        return String.format("%n%s - %s: Contato: %s, %s",getTipo(), getNome(), getTelefone(), getEndereco());
    }

    @Override
    protected String getTipo() {
        return "Empregado";
    }
}
