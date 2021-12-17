package exercicio6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Vendedor vendedor = new Vendedor();

        vendedor.setNome("Maria");

        vendedor.setEndereco("Florianópolis - SC");

        vendedor.setTelefone("(48) 9999 99999");

        System.out.println(vendedor.toString());

        vendedor.setComissao(4.5);

        vendedor.setValorVendas(20000);

        System.out.print("\nDigite o código do setor do empregado: ");

        int codigoDigitado = input.nextInt();

        if ((codigoDigitado > 0) && (codigoDigitado <= 4)) {

            System.out.printf("\nSalário líquido: R$ %.2f\n", vendedor.calcularSalario(codigoDigitado));

            System.out.printf("\n%s possui R$ %.2f de comissão.", vendedor.getTipo(), vendedor.calculaComissao());

        } else {
            System.out.println("\nOpção inválida.");
        }



    }
}
