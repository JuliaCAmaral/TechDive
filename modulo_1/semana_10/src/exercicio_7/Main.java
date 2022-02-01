package exercicio_7;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        try
        {
            InputStream fis = new FileInputStream("Exemplo.txt");
            Reader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);

            char character = readCharacter();

            int count = 0;
            int value;

            while((value = reader.read()) != -1) {
                value = Character.toLowerCase(value);

                if(character == value)
                    count++;
            }
            System.out.println("Total: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char readCharacter() {
        System.out.println("Por favor, digite 1 caracter alfanumérico.");

        while (true) {
            String character = input.nextLine().toLowerCase();

            if (character.length() != 1) {
                System.out.println("Entrada inválida. Digite apenas 1 caracter.");
                continue;
            }

            char c = character.charAt(0);
            if (!Character.isLetterOrDigit(c)) {
                System.out.println("Entrada inválida. Digite 1 caracter alfanumérico.");
                continue;
            }

            return c;
        }
    }
}
