import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double [] numerosInseridos = new double[2];

        for (int i = 0; i < numerosInseridos.length; i++) {

            System.out.printf("Por favor, inserir o %sº número: ", (i+1));
            numerosInseridos[i] = input.nextDouble();

        }

        System.out.printf("%nDe acordo com a tabela abaixo: %n");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.printf("%nDigite o código da operação que você deseja: ");

        int operacao = input.nextInt();

        double resultado = 0;

        switch (operacao) {

            case 1:
                resultado = numerosInseridos[0] + numerosInseridos[1];
                break;

            case 2:
                resultado = numerosInseridos[0] - numerosInseridos[1];
                break;

            case 3:
                resultado = numerosInseridos[0] * numerosInseridos[1];
                break;

            case 4:
                resultado = numerosInseridos[0] / numerosInseridos[1];
                break;

        }

        if (operacao > 0 && operacao < 5) {

            System.out.printf("%nO resultado é: %s%n", resultado);
        } else {
            System.out.println("Não foi possível identificar a operação.");
        }

    }
}
