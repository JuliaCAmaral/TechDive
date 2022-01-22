package exercicio_4;

import java.util.Scanner;

public class questao4 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Eu sei dividir");

        System.out.print("\nInforme o primeiro valor: ");
        double x = validaNumero();

        System.out.print("\nInforme o segundo valor: ");
        double y = lerDenominador();

        double r = x/y;

        System.out.printf("\n\nResultado da divisão: %f", r);
    }

    private static int lerDenominador() {
        while (true) {
            int denominador = validaNumero();

            if (denominador == 0) {
                System.out.print("O denominador não pode ser zero. Digite um valor válido: ");
                continue;
            }
            return denominador;
        }
    }

    private static int validaNumero() {
        while (true) {
            String numero = teclado.nextLine().trim();
            try {
                return Integer.parseInt(numero);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um valor válido: ");
            }
        }
    }
}
