import java.util.Scanner;

public class PerguntarNomeDoUsuario {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Qual é o seu sobrenome? ");
        String sobrenomne = input.nextLine().trim();

        System.out.println("Qual é o seu primeiro nome?");
        String primeiroNome = input.nextLine().trim();

        String nome = primeiroNome + " " + sobrenomne;

        int length = nome.length() - 1;

        System.out.printf("Olá %s, seu nome possui %s letras.", nome, length);
    }

}
