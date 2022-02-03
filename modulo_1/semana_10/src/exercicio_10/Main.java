package exercicio_10;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    private static final Banco banco = new Banco();

    public static void main(String[] args) {

        Agencia agencia1 = banco.criarAgencia("Florianópolis");

        Agencia agencia2 = banco.criarAgencia("São José");

        banco.carregarDados();

        while (true) {
            String opcao = lerOpcao();

            try {
                switch (opcao) {
                    case "1":
                        listarAgencias();
                        break;

                    case "2":
                        listarContas();
                        break;

                    case "3":
                        criarContaCorrente();
                        break;

                    case "4":
                        sacar();
                        break;

                    case "5":
                        depositar();
                        break;

                    case "6":
                        transferir();
                        break;

                    case "7":
                        consultarSaldo();
                        break;

                    case "8":
                        consultarExtrato();
                        break;

                    case "0":
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (opcao.equals("0")) {
                break;
            } else {
                System.out.print("\n----------------------------\n");
                System.out.println("Digite enter para continuar.");
                System.out.print("----------------------------\n\n");
                input.nextLine();
            }
        }
    }

    // ------------------------------------------------------------------------------

    public static String lerOpcao() {
        System.out.println("Digite:");
        System.out.println("1 - Listar agências");
        System.out.println("2 - Listar contas");
        System.out.println("3 - Criar conta");
        System.out.println("4 - Sacar");
        System.out.println("5 - Depositar");
        System.out.println("6 - Transferir");
        System.out.println("7 - Consultar saldo");
        System.out.println("8 - Consultar extrato");
        System.out.println("0 - Para sair");

        return input.nextLine();
    }

    public static void listarAgencias() {
        System.out.println();

        for(Agencia agencia : banco.getAgencias()) {
            System.out.println(agencia);
        }
    }

    public static void listarContas() {
        Agencia agencia = lerAgencia();

        System.out.println();

        Conta[] contas = agencia.getContas();

        for(Conta conta : contas) {
            System.out.println(conta);
        }

        if (contas.length == 0) {
            System.out.println("Nenhuma conta cadastrada.");
        }

        System.out.println("Operação realizada com sucesso.");

    }

    public static void criarContaCorrente() {

        Cliente cliente = lerCliente();

        Agencia agencia = lerAgencia();

        ContaCorrente conta = banco.criarContaCorrente(cliente, agencia);

        System.out.println();
        System.out.println("Detalhes da conta corrente:");
        System.out.println(conta);
        System.out.println("Operação realizada com sucesso.");
    }


    public static void sacar() {
        Agencia agencia = lerAgencia();

        Conta conta = lerConta(agencia);

        double valor = lerValorDouble("Digite o valor do saque ou sair para sair:");

        banco.sacar(conta, valor);

        System.out.println("Operação realizada com sucesso.");
    }

    public static void depositar() {
        Agencia agencia = lerAgencia();

        Conta conta = lerConta(agencia);

        double valor = lerValorDouble("Digite o valor do depósito ou sair para sair:");

        banco.depositar(conta, valor);

        System.out.println("Operação realizada com sucesso.");
    }

    public static void transferir() {
        Agencia agencia1 = lerAgencia("Digite o código da agência da conta de origem ou 0 para sair.");

        Conta conta1 = lerConta(agencia1, "Digite o código da conta de origem ou 0 para sair.");

        Agencia agencia2 = lerAgencia("Digite o código da agência da conta de destino ou 0 para sair.");

        Conta conta2 = lerConta(agencia2, "Digite o código da conta de destino ou 0 para sair.");

        double valor = lerValorDouble("Digite o valor da transferência:");

        banco.transferir(conta1, conta2, valor);

        System.out.println("Operação realizada com sucesso.");
    }

    public static void consultarSaldo() {
        Agencia agencia = lerAgencia();

        Conta conta = lerConta(agencia);

        System.out.println("Saldo atual:");

        System.out.println(conta);

        System.out.println("Operação realizada com sucesso.");
    }

    public static void consultarExtrato() {
        Agencia agencia = lerAgencia();

        Conta conta = lerConta(agencia);

        System.out.println();

        System.out.println(conta);

        System.out.println("Extrato:");

        for(Transacao transacao : conta.getExtrato()) {
            System.out.println(transacao);
        }

        System.out.println("Operação realizada com sucesso.");
    }

    public static Cliente lerCliente() {
        System.out.println("Digite o nome do cliente:");

        String nome = input.nextLine();

        String cpf = lerCpf();

        Cliente cliente = banco.criarCliente(nome, cpf);

        return cliente;
    }

    public static String lerCpf() {
        while (true) {
            System.out.println("Digite o CPF do cliente ou 0 para sair:");

            String entrada = input.nextLine().trim();

            if (entrada.equals("0")){
                throw new InvalidParameterException("Operação abortada.");
            }

            if (Cpf.valido(entrada)){
                return entrada;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    public static double lerValorDouble(String texto) {
        while (true) {
            System.out.println(texto);

            String entrada = input.nextLine();

            if (entrada.toLowerCase().equals("sair")){
                throw new InvalidParameterException("Operação abortada.");
            }

            try {
                double valor = Double.parseDouble(entrada);

                if(valor <= 0){
                    System.out.println("Opção inválida.");
                    continue;
                }

                return valor;
            } catch (Exception e){
                System.out.println("Opção inválida.");
            }
        }
    }

    public static Agencia lerAgencia() {
        return lerAgencia("Digite o código da agência ou 0 para sair.");

    }

    public static Agencia lerAgencia(String texto) {
        while (true) {
            System.out.println(texto);

            listarAgencias();

            String entrada = input.nextLine();

            if (entrada.equals("0")){
                throw new InvalidParameterException("Operação abortada.");
            }

            try {
                int codigo = Integer.parseInt(entrada);

                return banco.getAgencia(codigo);
            } catch (Exception e){
                System.out.println("Opção inválida.");
            }
        }
    }

    public static Conta lerConta(Agencia agencia) {
        return lerConta(agencia,"Digite o código da conta ou 0 para sair.");
    }

    public static Conta lerConta(Agencia agencia, String texto) {
        while (true) {
            System.out.println(texto);

            String entrada = input.nextLine();

            if (entrada.equals("0")){
                throw new InvalidParameterException("Operação abortada.");
            }

            try {
                int codigo = Integer.parseInt(entrada);

                return agencia.getConta(codigo);
            } catch (Exception e){
                System.out.println("Opção inválida.");
            }
        }
    }
}
