package exercicio_3;

public class TesteException {

    public static void main(String[] args) {
        System.out.println("Inicio do main");
        metodo1();
        System.out.println("Fim do main");
    }

    static void metodo1() {
        System.out.println("Inicio do metodo1");

        try {
            metodo2();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Falha ao executar o metodo1: " + e.getMessage());
        }
        System.out.println("Fim do metodo1");
    }

    static void metodo2() {
        System.out.println("Início do metodo2");
        int [] array = new int[10];
        for (int i = 0; i <= 15 ; i++) {
            array[i] = i;
            System.out.println(i);
        }
        System.out.println("Fim do metodo2");
    }
}
