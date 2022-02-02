package exercicio_8;

public class Cliente {

    private final String nome;

    private final String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", nome, cpf);
    }
}
