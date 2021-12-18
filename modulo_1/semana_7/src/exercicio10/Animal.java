package exercicio10;

public abstract class Animal {

    private String especie;

    private String som;

    private String onomatopeia;

    public Animal(String especie, String som, String onomatopeia) {
        this.especie = especie;
        this.som = som;
        this.onomatopeia = onomatopeia;
    }

    @Override
    public String toString() {
        return String.format("%s está %s: %s.", especie, som, onomatopeia);
    }
}
