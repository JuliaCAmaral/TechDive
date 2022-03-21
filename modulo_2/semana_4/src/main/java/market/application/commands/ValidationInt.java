package market.application.commands;

import java.util.Scanner;

public class ValidationInt {

    private Scanner input;

    public ValidationInt() {
    }

    public long readInt(Scanner input) {
        while (true) {
            String line = input.nextLine().trim();
            try {
                return Long.parseLong(line);

            } catch (NumberFormatException e) {
                System.out.println("Valor incorreto, digite novamente um número inteiro.");
            }
        }
    }
}
