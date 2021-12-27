package gerenciamentoFuncionarios;

public class LiderTecnico extends Pessoa {

    private String setor;

    private GerenteDeDepartamento gerenteDeDepartamento;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public GerenteDeDepartamento getGerenteDeDepartamento() {
        return gerenteDeDepartamento;
    }

    public void setGerenteDeDepartamento(GerenteDeDepartamento gerenteDeDepartamento) {
        this.gerenteDeDepartamento = gerenteDeDepartamento;
    }

    @Override
    public String getCargo() {
        return "Líder Técnico";
    }

    @Override
    public String toString() {
        return String.format("Líder Técnico: %s - setor %s", getNome(), this.setor);
    }
}
