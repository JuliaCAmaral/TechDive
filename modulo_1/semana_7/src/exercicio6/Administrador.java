package exercicio6;

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
    public double calcularSalario(int codigoSetor) {

        return super.calcularSalario(codigoSetor) + getAjudaDeCusto();
    }
}
