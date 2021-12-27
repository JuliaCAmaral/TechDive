package gerenciamentoFuncionarios;

public class GerenteGeral extends Pessoa {

    @Override
    public String getCargo() {
        return "Gerente Geral";
    }

    @Override
    public String toString() {
        return String.format("Gerente Geral: %s", getNome());
    }

}
