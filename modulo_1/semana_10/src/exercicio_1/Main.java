package exercicio_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite a sua data de nascimento (dd/mm/aaaa): ");

        LocalDate today = LocalDate.now();
        LocalDate birthday = readDate();

        int userAge = (int) ChronoUnit.YEARS.between(birthday, today);

        boolean underAge = userAge < 18;

        String access = underAge ? "não possui acesso ao sistema" : "possui acesso ao sistema";

        System.out.printf("%nVocê tem %d anos de idade, você %s.%n", userAge, access);

    }

    private static LocalDate readDate() {
        while (true) {
            String entryDate = input.nextLine().trim();

            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate userDate = LocalDate.parse(entryDate, dateFormatter);

                if (userDate.isAfter(LocalDate.now())) {
                    System.out.println("\nA data inserida não pode ser superior a data atual.");
                    System.out.print("Digite novamente a data (dd/mm/aaaa):");
                    continue;
                }
                return userDate;

            } catch (DateTimeParseException e) {
                System.out.print("\nData inválida. Digite novamente a data (dd/mm/aaaa):");
            }
        }
    }
}
