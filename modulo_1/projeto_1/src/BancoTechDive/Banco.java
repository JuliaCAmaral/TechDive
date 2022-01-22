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
}
