package exercicio_6;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("Exemplo.txt");
                Reader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {

            int length = fis.available();
            double lengthKb = length / 1024;
            double lengthMb = lengthKb / 1024;

            System.out.println("O tamanho do arquivo nas seguintes unidades:");
            System.out.println(length + " Bytes");
            System.out.println(lengthKb + " Kilobytes");
            System.out.println(lengthMb + " Megabytes");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
