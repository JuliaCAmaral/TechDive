package exercicio7;

public class Cachorro extends Animal {

    public String correr() {
        return String.format("%s está correndo.", getNome());
    }

    @Override
    protected String emiteSom() {
        return "O cachorro está latindo.";
    }

    @Override
    protected String getTipo() {
        return "Cachorro";
    }

}
