package BancoTechDive;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Agencia {

    private final int numero;

    private final String nome;

    private ArrayList<Banco.Conta> contas = new ArrayList<Banco.Conta>();

    public Agencia(int numero, String nome) {
        this.nome = nome;
        this.numero = numero;
    }

    public Banco.ContaCorrente criarContaCorrente(Cliente cliente) {
        int numeroConta = contas.size() + 1;
        Banco.ContaCorrente contaCorrente = new Banco.ContaCorrente(numeroConta, this.numero, cliente);
        contas.add(contaCorrente);
        return contaCorrente;
    }

    public Banco.ContaPoupanca criarContaPoupanca(Cliente cliente) {
        int numeroConta = contas.size() + 1;
        Banco.ContaPoupanca contaPoupanca = new Banco.ContaPoupanca(numeroConta, this.numero, cliente);
        contas.add(contaPoupanca);
        return contaPoupanca;
    }

    public Banco.ContaInvestimento criarContaInvestimento(Cliente cliente) {
        int numeroConta = contas.size() + 1;
        Banco.ContaInvestimento contaInvestimento = new Banco.ContaInvestimento(numeroConta, this.numero, cliente);
        contas.add(contaInvestimento);
        return contaInvestimento;
    }

    public Banco.Conta getConta(int codigo) {
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

    public Banco.Conta[] getContas() {
        return contas.toArray(new Banco.Conta[0]);
    }

    @Override
    public String toString() {
        return String.format("Agência: %03d - %s.",numero, nome);
    }
}
