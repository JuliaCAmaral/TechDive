package exercicio10;

public class Main {

    public static void main(String[] args) {
        ClasseA classeA = new ClasseA();
        ClasseA.ClasseB classeB = classeA.new ClasseB();
        ClasseA.ClasseC classeC = new ClasseA.ClasseC();
    }
}
