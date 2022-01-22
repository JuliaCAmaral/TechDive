package modal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    List <Conta> contas = new ArrayList<>();

    public void add(Conta conta) {
        contas.add(conta);
    }

    public int getQuantidadeDeContas() {
        return contas.size();
    }

    public List<Conta> buscaPorTitular(String nomeDoTitular) {
        String nomeDoTitular2 = nomeDoTitular.toLowerCase();

        List<Conta> resultado = contas.stream()
                .filter(conta -> conta.getCliente().getNome().toLowerCase().contains(nomeDoTitular2))
                .collect(Collectors.toList());

        return resultado;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
