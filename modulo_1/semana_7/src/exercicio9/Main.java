package exercicio9;

public class Main {

    public static void main(String[] args) {

        Animal cachorro = new Cachorro();

        Animal cavalo = new Cavalo();

        Animal preguica = new Preguica();

        Veterinario veterinario = new Veterinario();

        cachorro.setNome("Belinha");

        cachorro.setIdade(7);

        cavalo.setNome("Faísca");

        cavalo.setIdade(10);

        preguica.setNome("Scrat");

        preguica.setIdade(22);

        veterinario.examinar(cachorro);

        veterinario.examinar(cavalo);

        veterinario.examinar(preguica);

    }
}
