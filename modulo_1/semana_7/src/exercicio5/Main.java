package exercicio5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Operario operario = new Operario();

        operario.setNome("Maria");

        operario.setEndereco("Florianópolis - SC");

        operario.setTelefone("(48) 9999 99999");

        System.out.println(operario.toString());

        operario.setPorcentagemComissao(10);

        operario.setValorProducao(7000);

        System.out.print("\nDigite o código do setor do empregado: ");

        int codigoDigitado = input.nextInt();

        if ((codigoDigitado > 0) && (codigoDigitado <= 4)) {

            System.out.printf("\nSalário líquido: R$ %.2f\n", operario.calcularSalario(codigoDigitado));

            System.out.printf("\n%s possui R$ %.2f de comissão.", operario.getTipo(), operario.comissao());

        } else {
            System.out.println("\nOpção inválida.");
        }



    }
}
