package exercicio_10;

import java.io.*;
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

    public Cliente criarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        return cliente;
    }

    public ContaCorrente criarContaCorrente(Cliente cliente, Agencia agencia) {
        ContaCorrente conta = agencia.criarContaCorrente(cliente);
        salvarDados();
        return conta;
    }

    public void sacar(Conta conta, double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor do saque não pode ser negativo.");
        }
        Transacao saque = new Transacao(LocalDateTime.now(), "Saque", valor*(-1));

        conta.addTransacao(saque);
        salvarDados();
    }

    public void depositar(Conta conta, double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor do deposito não pode ser negativo.");
        }
        Transacao deposito = new Transacao(LocalDateTime.now(), "Deposito", valor);

        conta.addTransacao(deposito);
        salvarDados();
    }

    public void transferir(Conta conta1, Conta conta2, double valor) {

        Transacao transacao1 = new Transacao(LocalDateTime.now(), "Transferencia", valor * (-1));

        conta1.addTransacao(transacao1);

        Transacao transacao2 = new Transacao(LocalDateTime.now(), "Transferência", valor);

        conta2.addTransacao(transacao2);
        salvarDados();
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

    public void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dadosContas.csv"))) {

            for (Agencia agencia : getAgencias()) {
                for (Conta conta : agencia.getContas()) {
                    bw.write( agencia.getNumero() + "," + conta.getNumero() + "," + conta.getSaldo() + ","
                            + conta.getCliente().getNome() + "," + conta.getCliente().getCpf());
                    bw.newLine();
                }
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (BufferedReader br = new BufferedReader(new FileReader("dadosContas.csv"))) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Conta conta = carregarConta(attributes);

                Agencia agencia = getAgencia(conta.getAgencia());

                agencia.addConta(conta);
                line = br.readLine();

                carregarExtrato(conta);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarExtrato(Conta conta) {
        try (BufferedReader br = new BufferedReader(new FileReader("extratos/" + conta.getAgencia() + "/" + conta.getNumero() + ".csv"))) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");

                LocalDateTime dateTime = LocalDateTime.parse(attributes[0]);
                Transacao transacao = new Transacao(dateTime, attributes[1], Double.parseDouble(attributes[2]));

                conta.importTransacao(transacao);

                line = br.readLine();
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Conta carregarConta(String[] metadata) {
        int agencia = Integer.parseInt(metadata[0]);
        int IdConta = Integer.parseInt(metadata[1]);
        double saldo = Double.parseDouble(metadata[2]);
        String nome = metadata[3];
        String cpf = metadata[4];

        Conta conta = new ContaCorrente(IdConta, agencia, new Cliente(nome, cpf));
        conta.setSaldo(saldo);

        return conta;
    }
}
