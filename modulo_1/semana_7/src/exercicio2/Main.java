package exercicio2;

public class Main {

    public static void main(String[] args) {

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome("Maria");

        fornecedor.setEndereco("Florianópolis - SC");

        fornecedor.setTelefone("(48) 9999 99999");

        fornecedor.setValorCredito(5000);

        fornecedor.setValorDivida(2350);

        System.out.println(fornecedor.toString());

    }
}
