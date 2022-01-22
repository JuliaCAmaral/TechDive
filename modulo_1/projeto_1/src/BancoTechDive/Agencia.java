package BancoTechDive;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Agencia {

    private final int numero;

    private final String nome;

    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public Agencia(int numero, String nome) {
        this.nome = nome;
        this.numero = numero;
    }

    public ContaCorrente criarContaCorrente(Cliente cliente) {
        int numeroConta = contas.size() + 1;
        ContaCorrente contaCorrente = new ContaCorrente(numeroConta, this.numero, cliente);
        contas.add(contaCorrente);
        return contaCorrente;
    }

    public ContaPoupanca criarContaPoupanca(Cliente cliente) {
        int numeroConta = contas.size() + 1;
        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, this.numero, cliente);
        contas.add(contaPoupanca);
        return contaPoupanca;
    }

    public ContaInvestimento criarContaInvestimento(Cliente cliente) {
        int numeroConta = contas.size() + 1;
        ContaInvestimento contaInvestimento = new ContaInvestimento(numeroConta, this.numero, cliente);
        contas.add(contaInvestimento);
        return contaInvestimento;
    }

    public Conta getConta(int codigo) {
        if (codigo < 0 || codigo > contas.size()){
            throw new InvalidParameterException("Conta inválida.");
        }

        return contas.get(codigo - 1);
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Conta[] getContas() {
        return contas.toArray(new Conta[0]);
    }

    @Override
    public String toString() {
        return String.format("Agência: %03d - %s.",numero, nome);
    }
}
