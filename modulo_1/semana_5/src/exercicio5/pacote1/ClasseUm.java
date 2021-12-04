package exercicio5.pacote1;

import exercicio5.pacote2.*;

public class ClasseUm {

    public static void main(String[] args) {

        ClasseDois.imprimeTextoEstatico();

        ClasseDois classeDois = new ClasseDois();

        classeDois.imprimeTexto();
    }

}
