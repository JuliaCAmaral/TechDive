import java.util.Scanner;

public class CalculadoraDeMediaFinal {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        float[] notasInseridas = new float[3];

        int i = 0;

        do {
            System.out.printf("Por favor, inserir a %sº nota: ", (i+1));

            float notaInseridaAgora = input.nextFloat();

            if (notaInseridaAgora >= 0 && notaInseridaAgora <= 10) {
                notasInseridas[i] = notaInseridaAgora;
                i++;

            } else {
                System.out.println("A nota deve ser entre 0 e 10.");
            }

        } while (i < notasInseridas.length);

        float somaNotas = 0;

        for (float nota: notasInseridas) {
            somaNotas += nota;
        }

        float mediaDasNotas = somaNotas / notasInseridas.length;

        System.out.printf("Sua média final é: %.2f", mediaDasNotas);
    }
}
