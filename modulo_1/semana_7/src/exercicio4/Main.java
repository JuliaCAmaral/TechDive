package exercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Administrador administrador = new Administrador();

        administrador.setNome("Maria");

        administrador.setEndereco("Florianópolis - SC");

        administrador.setTelefone("(48) 9999 99999");

        System.out.println(administrador.toString());

        administrador.setAjudaDeCusto(400);

        System.out.print("\nDigite o código do setor do empregado: ");

        int codigoDigitado = input.nextInt();

        if ((codigoDigitado > 0) && (codigoDigitado <= 4)) {

            System.out.printf("\nSalário líquido: R$ %.2f\n", administrador.calcularSalario(codigoDigitado));

            System.out.printf("\n%s possui R$ %.2f de ajuda de custo.", administrador.getTipo(), administrador.getAjudaDeCusto());

        } else {
            System.out.println("\nOpção inválida.");
        }



    }
}
