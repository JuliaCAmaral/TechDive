package exercicio3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Empregado empregado = new Empregado();

        empregado.setNome("Maria");

        empregado.setEndereco("Florianópolis - SC");

        empregado.setTelefone("(48) 9999 99999");

        System.out.println(empregado.toString());

        System.out.print("\nDigite o código do setor do empregado: ");

        int codigoDigitado = input.nextInt();

        if ((codigoDigitado > 0) && (codigoDigitado <= 4)) {

            System.out.printf("\nSalário líquido: R$ %.2f", empregado.calcularSalario(codigoDigitado));

        } else {
            System.out.println("Opção inválida.");
        }
    }
}
