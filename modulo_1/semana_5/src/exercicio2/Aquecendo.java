package exercicio2;

public class Aquecendo {
    private String message;

    public Aquecendo() {
        this("Legal!");
        System.out.println("Este é o construtor 1.");
    }

    public Aquecendo(String message) {
        this.message = message;
        System.out.printf("%nEste é o construtor 2: %s%n", message);
    }

    public static void main(String[] args) {

        new Aquecendo();
    }
}
