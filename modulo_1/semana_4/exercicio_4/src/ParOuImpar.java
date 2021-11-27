import java.util.Scanner;

public class ParOuImpar {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = input.nextInt();

        boolean even = numero % 2 == 0;

        String paridade = even ? "par" : "ímpar";

        System.out.printf("%n O número %s é %s.%n", numero, paridade);

    }
}
