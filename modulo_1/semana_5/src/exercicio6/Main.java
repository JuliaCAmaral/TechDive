package exercicio6;

public class Main {

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro(){
            public void latir() {
                System.out.println("Au au!");

            }
        };

        cachorro.latir();
    }
}
