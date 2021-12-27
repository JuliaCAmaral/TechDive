package gerenciamentoFuncionarios;

public class Colaborador extends Pessoa {

    private String funcao;

    private LiderTecnico liderTecnico;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public LiderTecnico getLiderTecnico() {
        return liderTecnico;
    }

    public void setLiderTecnico(LiderTecnico liderTecnico) {
        this.liderTecnico = liderTecnico;
    }

    @Override
    public String getCargo() {
        return "Colaborador";
    }

    @Override
    public String toString() {
        return String.format("Colaborador: %s - função: %s", getNome(), this.funcao);
    }
}
