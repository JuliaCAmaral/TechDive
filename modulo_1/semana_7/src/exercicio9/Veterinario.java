package exercicio9;

public class Veterinario {

    public void examinar(Animal animal) {
        System.out.printf("\n%s foi examinado.", animal.getNome());
        System.out.println(animal.toString());
    }
}
