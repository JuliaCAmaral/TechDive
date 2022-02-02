package exercicio_8;

public class Cpf {

    public static boolean valido(String cpf) {

        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        if (cpf.length() != 11)
            return false;

        char digito10;
        char digito11;
        int soma = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            int num = (int) (cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso = peso - 1;
        }

        int r = 11 - (soma % 11);
        if ((r == 10) || (r == 11))
            digito10 = '0';
        else
            digito10 = (char) (r + 48);

        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            int num = (int) (cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (soma % 11);
        if ((r == 10) || (r == 11))
            digito11 = '0';
        else
            digito11 = (char) (r + 48);

        return ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10)));
    }
}
