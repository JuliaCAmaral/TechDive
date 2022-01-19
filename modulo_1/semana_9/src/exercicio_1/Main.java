package exercicio_1;

public class Main {

    public static void main(String[] args) {

        Agencia agencia = new Agencia();

        agencia.add(new ContaCorrente("Amanda", 100));
        agencia.add(new ContaCorrente("Gabriela", 800));
        agencia.add(new ContaCorrente("Fernando", 500));
        agencia.add(new ContaCorrente("João", 150));
        agencia.add(new ContaCorrente("Guilherme", 200));

        agencia.add(new ContaPoupanca("Yasmin", 1000));
        agencia.add(new ContaPoupanca("Suelen", 5000));
        agencia.add(new ContaPoupanca("Daniel", 2500));
        agencia.add(new ContaPoupanca("Ramon", 4100));
        agencia.add(new ContaPoupanca("Kiara", 2300));

        for (Conta contas : agencia.contas) {
            System.out.printf("%s - Cliente: %s%n", contas.getTipo(), contas.getNomeCliente());
        }

        System.out.printf("\nContas ativas: %d", agencia.getQuantidadeDeContas());
    }
}
