package BancoTechDive;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(int numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }

    @Override
    protected String getTipo() {
        return "Conta Investimento";
    }

}
