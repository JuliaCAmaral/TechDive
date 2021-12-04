package exercicio7;

public class FinalClass {

    private FinalClass() {

    }

    public static FinalClass createInstance() {
        return new FinalClass();
    }

    public void HelloWorld() {
        System.out.println("Hello World!");
    }
}
