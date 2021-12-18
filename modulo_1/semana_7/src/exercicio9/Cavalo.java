package exercicio9;

public class Cavalo extends Animal {

    public String correr() {
        return String.format("O %s está correndo.", getNome());
    }

    @Override
    protected String emiteSom() {
        return "O cavalo está relinchando.";
    }

    @Override
    protected String getTipo() {
        return "Cavalo";
    }
}
