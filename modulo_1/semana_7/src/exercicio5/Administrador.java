package exercicio5;

public class Administrador extends Empregado {

    private double ajudaDeCusto;

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }


    @Override
    protected String getTipo() {
        return "Administrador";
    }

    @Override
    public String toString() {
        return String.format("%n%s - %s: Contato: %s, %s",getTipo(), getNome(), getTelefone(), getEndereco());

    }

    @Override
    public double calcularSalario(int codigoSetor) {

        double salarioAdministrador = super.calcularSalario(codigoSetor) + getAjudaDeCusto();

        return salarioAdministrador;
    }
}
