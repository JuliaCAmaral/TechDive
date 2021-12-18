package exercicio8;

public class Main {

    public static void main(String[] args) {

        Animal cachorro = new Cachorro();

        Animal cavalo = new Cavalo();

        Animal preguica = new Preguica();

        cachorro.setNome("Belinha");

        cachorro.setIdade(7);

        cavalo.setNome("Faísca");

        cavalo.setIdade(10);

        preguica.setNome("Scrat");

        preguica.setIdade(22);

        System.out.println(cachorro.toString());

        System.out.println(cachorro.emiteSom());

        System.out.println(cavalo.toString());

        System.out.println(cavalo.emiteSom());

        System.out.println(preguica.toString());

        System.out.println(preguica.emiteSom());

    }
}
