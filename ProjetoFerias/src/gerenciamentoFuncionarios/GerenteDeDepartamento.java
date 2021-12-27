package gerenciamentoFuncionarios;

public class GerenteDeDepartamento extends Pessoa {

    private String departamento;

    private GerenteGeral gerenteGeral;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public GerenteGeral getGerenteGeral() {
        return gerenteGeral;
    }

    public void setGerenteGeral(GerenteGeral gerenteGeral) {
        this.gerenteGeral = gerenteGeral;
    }

    @Override
    public String getCargo() {
        return "Gerente de Departamento";
    }

    @Override
    public String toString() {
        return String.format("Gerente de Departamento: %s - departamento %s", getNome(), this.departamento);
    }
}
