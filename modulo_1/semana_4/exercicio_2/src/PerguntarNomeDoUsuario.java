// Crie um programa em Java que, utilizando a classe Scanner, pergunte ao usuário seu sobrenome, depois seu nome, e então escreva na tela, em uma única “string”, o nome completo do usuário.
// Informe também ao usuário quantas letras tem no nome dele.

import java.util.Scanner;

public class PerguntarNomeDoUsuario {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Qual é o seu sobrenome? ");
        String sobrenomne = input.nextLine();

        System.out.println("Qual é o seu primeiro nome?");
        String nome = input.nextLine();

        System.out.println(nome + " " + sobrenomne + ", seu nome possui " + nome.length() + " letras.");
    }


}
