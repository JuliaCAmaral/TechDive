package exercicio7;

public class Animal {

    private String nome;

    private int idade;

    protected String emiteSom() {
        return null;
    }

    protected String getTipo() {
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String toString() {
        return String.format("\n%s: %s possui %s anos.", getTipo(), getNome(), getIdade());
    }
}
