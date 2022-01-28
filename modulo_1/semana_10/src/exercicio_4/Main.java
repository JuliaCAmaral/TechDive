package exercicio_4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Insira uma data (dd/mm/aaaa): ");
        LocalDate userDate = readDate();

        if (userDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) && userDate.getDayOfMonth() == 13) {
            System.out.println("A data inserida é sexta-feira 13.");
        } else {
            System.out.println("A data inserida não é sexta-feira 13.");
        }
    }

    private static LocalDate readDate() {
        while (true) {
            String entryDate = input.nextLine().trim();

            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(entryDate, dateFormatter);

            } catch (DateTimeParseException e) {
                System.out.print("\nData inválida. Digite novamente a data (dd/mm/aaaa):");
            }
        }
    }
}
