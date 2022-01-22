package BancoTechDive;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Banco {

    private final ArrayList<Agencia> agencias = new ArrayList<Agencia>();

    private final ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Agencia criarAgencia(String nome) {
        int numero = agencias.size() + 1;
        Agencia agencia = new Agencia(numero, nome);
        agencias.add(agencia);
        return agencia;
    }

    public Cliente criarCliente(String nome, String cpf, double renda) {
        Cliente cliente = new Cliente(nome, cpf);
        cliente.setRenda(renda);
        clientes.add(cliente);
        return cliente;
    }

    public void sacar(Conta conta, double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor do saque não pode ser negativo.");
        }
        Transacao saque = new Transacao(LocalDateTime.now(), "Saque", valor*(-1));
        conta.addTransacao(saque);
    }

    public void depositar(Conta conta, double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor do deposito não pode ser negativo.");
        }
        Transacao deposito = new Transacao(LocalDateTime.now(), "Deposito", valor);
        conta.addTransacao(deposito);
    }

    public void transferir(Conta conta1, Conta conta2, double valor) {

        Transacao transacao1 = new Transacao(LocalDateTime.now(), "Transferencia", valor * (-1));

        conta1.addTransacao(transacao1);

        Transacao transacao2 = new Transacao(LocalDateTime.now(), "Transferência", valor);

        conta2.addTransacao(transacao2);
    }

    public double calcularRendabilidade(double valor, int meses, double taxa) {

        double taxaConvertida = (taxa / 100);

        double taxaMensal = (taxaConvertida / 12) + 1;

        return Math.pow(taxaMensal, meses) * valor;
    }

    public Agencia getAgencia(int codigo) {
        if (codigo < 0 || codigo > agencias.size()){
            throw new InvalidParameterException("Agencia inválida.");
        }

        return agencias.get(codigo - 1);
    }

    public Agencia[] getAgencias() {
        return agencias.toArray(new Agencia[0]);
    }

    public abstract static class Conta {

        private final int numero;

        private final int agencia;

        private final Cliente cliente;

        private final ArrayList<Transacao> transacoes = new ArrayList<>();

        private double saldo;

        public Conta(int numero, int agencia, Cliente cliente) {
            this.numero = numero;
            this.agencia = agencia;
            this.cliente = cliente;
        }

        protected abstract String getTipo();

        protected void addTransacao(Transacao transacao) {

            if (transacao.getValor() < 0) {

                double limite = getLimite();

                if (getSaldo() + transacao.getValor() < limite * (-1)) {
                    throw new RuntimeException("Limite excedido ");
                }
            }

            this.saldo = this.saldo + transacao.getValor();
            transacoes.add(transacao);
        }

        public Transacao[] getExtrato() {
            return transacoes.toArray(new Transacao[0]);
        }

        protected double getLimite() {
            return 0;
        }

        public int getNumero() {
            return numero;
        }

        public int getAgencia() {
            return agencia;
        }

        public double getSaldo() {
            return saldo;
        }

        public Cliente getCliente() {
            return cliente;
        }

        @Override
        public String toString() {
            return String.format("%s - Número %05d, Agência %03d, Saldo R$ %.2f.", getTipo(), numero, agencia, saldo);
        }
    }

    public static class ContaCorrente extends Conta {

        public ContaCorrente(int numero, int agencia, Cliente cliente) {
            super(numero, agencia, cliente);
        }

        @Override
        protected String getTipo() {
            return "Conta Corrente";
        }

        @Override
        protected double getLimite() {

            Cliente cliente = getCliente();

            double limite = cliente.getRenda() * 0.5;

            return limite;
        }
    }

    public static class ContaInvestimento extends Conta {

        public ContaInvestimento(int numero, int agencia, Cliente cliente) {
            super(numero, agencia, cliente);
        }

        @Override
        protected String getTipo() {
            return "Conta Investimento";
        }

    }

    public static class ContaPoupanca extends Conta {

        public ContaPoupanca(int numero, int agencia, Cliente cliente) {
            super(numero, agencia, cliente);
        }

        @Override
        protected String getTipo() {
            return "Conta Poupança";
        }
    }
}
