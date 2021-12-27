package gerenciamentoFuncionarios;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public void addFuncionario(Pessoa pessoa) {
        int matricula = pessoas.size() + 1;

        pessoa.setAtivo(true);
        pessoa.setMatricula(matricula);

        pessoas.add(pessoa);
    }

    public Funcionario getFuncionario(int matricula) {
        return getPessoa(matricula);
    }

    private Pessoa getPessoa(int matricula) {
        if (matricula <= 0 || matricula > pessoas.size()) {
            throw new InvalidParameterException("Matrícula inválida.");
        }

        return pessoas.get(matricula - 1);
    }

    public void demitir(int matricula) {

        Pessoa pessoa = getPessoa(matricula);
        pessoa.setAtivo(false);
    }

    public void atualizarNome(int matricula, String novoNome) {

        Pessoa pessoa = getPessoa(matricula);
        pessoa.setNome(novoNome);
    }

    public void atualizaTelefone(int matricula, String novoTelefone) {

        Pessoa pessoa = getPessoa(matricula);
        pessoa.setTelefone(novoTelefone);
    }

    public void atualizarSalario(int matricula, double salario) {

        Pessoa pessoa = getPessoa(matricula);
        pessoa.setSalario(salario);
    }

    public Funcionario[] getTodos(){
        return pessoas.toArray(new Funcionario[0]);
    }

    public List<Funcionario> getAtivos() {
        return getAtivoOuDemetido(true);
    }

    public List<Funcionario> getDemitidos() {
        return getAtivoOuDemetido(false);
    }

    public List<Funcionario> getAtivoOuDemetido(boolean ativo) {
        ArrayList<Funcionario> lista = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.isAtivo() == ativo){
                lista.add(pessoa);
            }
        }

        return lista;
    }
}
