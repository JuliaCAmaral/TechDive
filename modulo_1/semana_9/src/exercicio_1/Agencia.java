package exercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    List <Conta> contas = new ArrayList<>();

    public void add(Conta conta) {
        contas.add(conta);
    }

    public int getQuantidadeDeContas() {
        return contas.size();
    }

}
