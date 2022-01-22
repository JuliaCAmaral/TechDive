package view;

import modal.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Agencia agencia = new Agencia();

        agencia.add(new ContaCorrente(new Cliente("Amanda Souza"), 100));
        agencia.add(new ContaCorrente(new Cliente("Gabriela Castelo"), 800));
        agencia.add(new ContaCorrente(new Cliente("Fernando Soares"), 500));
        agencia.add(new ContaCorrente(new Cliente("João Biz"), 150));
        agencia.add(new ContaCorrente(new Cliente("Guilherme Fortes"), 200));

        agencia.add(new ContaPoupanca(new Cliente("Yasmin Correia"), 1000));
        agencia.add(new ContaPoupanca(new Cliente("Suelen Fernandez"), 5000));
        agencia.add(new ContaPoupanca(new Cliente("Fernando Soares"), 2500));
        agencia.add(new ContaPoupanca(new Cliente("João Manuel"), 4100));
        agencia.add(new ContaPoupanca(new Cliente("Kiara Piaget"), 2300));

        for (Conta contas : agencia.getContas()) {
            System.out.printf("%s - Cliente: %s%n", contas.getTipo(), contas.getCliente().getNome());
        }

        System.out.printf("\nContas ativas: %d%n", agencia.getQuantidadeDeContas());

        System.out.print("Digite o nome do cliente para buscar as contas: ");

        String nomeBusca = lerNome();

        List<Conta> contasBuscadas = agencia.buscaPorTitular(nomeBusca);

        if (!(contasBuscadas.size() == 0)) {
            for (Conta contas : contasBuscadas) {
                System.out.printf("Titular: %s - %s - Saldo: R$ %.2f%n", contas.getCliente().getNome(),contas.getTipo(), contas.getSaldo());
            }

        } else {
            System.out.printf("%s não possui nenhuma conta no banco.", nomeBusca);
        }

    }
    private static String lerNome() {
        while (true) {
            String entradaUsuario = input.nextLine().trim();

            if (!entradaUsuario.isEmpty()) {
                return entradaUsuario;
            } else {
                System.out.println("O nome não pode ser vazio. Digite novamente: ");
            }
        }
    }
}
