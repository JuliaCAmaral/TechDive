package exercicio8;

public class Classe2 {

    private final Classe1 classe1;

    public Classe2(Classe1 classe1) {
        this.classe1 = classe1;
    }

    public void setAtributo(String atributo) {
        classe1.setAtributo(atributo);
    }

}
