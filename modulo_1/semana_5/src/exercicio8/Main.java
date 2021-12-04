package exercicio8;

public class Main {

    public static void main(String[] args) {

        Classe1 classe1 = new Classe1();
        Classe2 classe2 = new Classe2(classe1);

        classe2.setAtributo("Olá mundo!");

        System.out.println(classe1.getAtributo());
    }
}
