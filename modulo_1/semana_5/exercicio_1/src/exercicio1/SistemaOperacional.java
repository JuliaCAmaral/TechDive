package exercicio1;

public class SistemaOperacional {

    public static void main(String[] args) {

        String os = System.getProperty("os.name");

        System.out.printf("%nSistema operacional: %s%n", os);

        Runtime runtime = Runtime.getRuntime();

        long maxMemory = (runtime.maxMemory() / 1024) / 1024;
        System.out.printf("%nCapacidade de memória RAM: %s Mb%n", maxMemory);

        long usedMemory = ((runtime.totalMemory() - runtime.freeMemory()) / 1024) / 1024;
        System.out.printf("Memória RAM ocupada: %s Mb%n", usedMemory);

        long freeMemory = (runtime.freeMemory() / 1024) / 1024;
        System.out.printf("Memória livre: %s Mb%n", freeMemory);

    }

}
