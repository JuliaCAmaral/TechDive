package exercicio_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void addConta(Conta conta) {
        contas.add(conta);
    }
}
