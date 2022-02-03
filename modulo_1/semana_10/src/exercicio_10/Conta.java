package exercicio_10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Conta {
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

        try {

            java.nio.file.Path path = java.nio.file.Paths.get("extratos");
            java.nio.file.Files.createDirectories(path);

            path = java.nio.file.Paths.get("extratos/" + agencia);
            java.nio.file.Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("extratos/" + agencia + "/" + numero + ".csv", true))) {

            bw.write(transacao.getDataHora() + "," + transacao.getDescricao() + "," + transacao.getValor());
            bw.newLine();

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        transacoes.add(transacao);
    }

    public void importTransacao(Transacao transacao) {
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

    protected double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return String.format("%s - Número %05d, Agência %03d, Saldo R$ %.2f.", getTipo(), numero, agencia, saldo);
    }


}
