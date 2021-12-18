package exercicio8;

public class Preguica extends Animal {

    public String subir() {
        return String.format("%s %s está subindo na árvore.", getTipo(), getNome());
    }

    @Override
    protected String emiteSom() {
        return "A preguiça está fazendo barulho.";
    }

    @Override
    protected String getTipo() {
        return "Preguiça";
    }
}
