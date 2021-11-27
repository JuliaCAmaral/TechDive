import java.util.Scanner;

public class JogoAdivinha {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Adivinhe qual número de 1 a 5 eu estou pensando.");
        int adivinhacaoDoUsuario = input.nextInt();

        int numeroSorteado = (int) (Math.random() * (6-1) + 1);

        if (numeroSorteado != adivinhacaoDoUsuario) {
            System.out.printf("Você errou, o número correto era: %s", numeroSorteado);
        } else {
            System.out.println("Você acertou!");
        }

    }
}
