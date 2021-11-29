import java.util.Scanner;

public class CalculadoraPAPG {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.printf("%nPor favor, inserir um número inteiro: ");
        double numeroInserido = input.nextInt();

        System.out.printf("%nPor favor, inserir o valor da raiz: ");
        double raiz = input.nextInt();

        System.out.printf("%nVocê quer os 10 primeiros termos de uma PA ou de uma PG?%n");
        System.out.println("1 - Progressão Aritmética");
        System.out.println("2 - Progressão Geométrica");

        int operacao;

        do {
            System.out.print("Por favor, digite o código desejável: ");
            operacao = input.nextInt();
        } while (!(operacao == 1 || operacao ==2));

        double [] termos = new double[10];

        String tipo = null;

        switch (operacao) {
            case 1:
                for (int i = 0; i < termos.length; i++) {
                    termos[i] = numeroInserido + (i * raiz);
                }
                tipo = "PA";
                break;

            case 2:
                for (int i = 0; i < termos.length; i++) {
                    termos[i] = numeroInserido * Math.pow(raiz, i);
                }
                tipo = "PG";
                break;
        }

        for (int i = 0; i < termos.length; i++) {
            if (i == 0) {
                System.out.printf("%nOs 10 primeiros termos da %s são: {%.0f", tipo, termos[0]);
            } else {
                System.out.printf(", %.0f", termos[i]);
            }
        }

        System.out.println("}");

    }
}
