package exercicio9;

public class Animal {

    static {
        System.out.println("Dentro do bloco static: Au au!");
    }

    {
        System.out.println("Dentro do bloco de instância: Miau!");
    }

    public Animal() {
        System.out.println("Dentro do construtor: Muuuu!");
    }

}
