package BancoTechDive;

import java.security.InvalidParameterException;

public class Cliente {

    private final String nome;

    private final String cpf;

    private double renda;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", nome, cpf);
    }
}
