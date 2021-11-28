import java.util.Scanner;

public class CalculadoraFatorial {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numeroInserido;

        do {
            System.out.print("Por favor, inserir um número inteiro entre 0 e 10: ");

            numeroInserido = input.nextInt();

        } while (numeroInserido < 0 || numeroInserido > 10);

        int resultado = 1;

        for (int i = numeroInserido; i > 0; i--) {
            resultado = resultado * i;
        }

        System.out.printf("O resultado de %s! é %s%n", numeroInserido, resultado);

    }
}
